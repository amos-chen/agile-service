package io.choerodon.agile.api.controller.v1;


import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.core.base.BaseController;
import io.choerodon.core.exception.CommonException;
import io.choerodon.agile.api.validator.StateValidator;
import io.choerodon.agile.api.vo.*;
import io.choerodon.agile.app.service.ProjectConfigService;
import io.choerodon.agile.app.service.StatusService;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.swagger.annotation.CustomPageRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.starter.keyencrypt.core.Encrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author shinan.chen
 * @since 2018/9/27
 */
@RestController
@RequestMapping(value = "/v1")
public class StatusController extends BaseController {

    @Autowired
    private StatusService statusService;
    @Autowired
    private StateValidator stateValidator;
    @Autowired
    private ProjectConfigService projectConfigService;

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "分页查询状态列表")
    @CustomPageRequest
    @PostMapping("/organizations/{organization_id}/status/list")
    public ResponseEntity<Page<StatusWithInfoVO>> queryStatusList(@ApiIgnore
                                                                      @SortDefault(value = "id", direction = Sort.Direction.DESC) PageRequest pageRequest,
                                                                  @ApiParam(value = "组织id", required = true)
                                                                      @PathVariable("organization_id") Long organizationId,
                                                                  @ApiParam(value = "status search dto", required = true)
                                                                      @RequestBody StatusSearchVO statusSearchVO) {
        return Optional.ofNullable(statusService.queryStatusList(pageRequest, organizationId, statusSearchVO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.statusList.get"));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "创建状态")
    @PostMapping("/organizations/{organization_id}/status")
    public ResponseEntity<StatusVO> create(@PathVariable("organization_id") Long organizationId,
                                           @RequestBody StatusVO statusVO) {
        stateValidator.validate(statusVO);
        return new ResponseEntity<>(statusService.create(organizationId, statusVO), HttpStatus.CREATED);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "更新状态")
    @PutMapping(value = "/organizations/{organization_id}/status/{status_id}")
    public ResponseEntity<StatusVO> update(@PathVariable("organization_id") Long organizationId,
                                           @PathVariable("status_id") @Encrypt Long statusId,
                                           @RequestBody @Valid  StatusVO statusVO) {
        statusVO.setId(statusId);
        statusVO.setOrganizationId(organizationId);
        stateValidator.validate(statusVO);
        return new ResponseEntity<>(statusService.update(statusVO), HttpStatus.CREATED);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "删除状态")
    @DeleteMapping(value = "/organizations/{organization_id}/status/{status_id}")
    public ResponseEntity<Boolean> delete(@PathVariable("organization_id") Long organizationId,
                                          @PathVariable("status_id") @Encrypt Long statusId) {
        return new ResponseEntity<>(statusService.delete(organizationId, statusId), HttpStatus.NO_CONTENT);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据id查询状态对象")
    @GetMapping(value = "/organizations/{organization_id}/status/{status_id}")
    public ResponseEntity<StatusVO> queryStatusById(@PathVariable("organization_id") Long organizationId,
                                                        @PathVariable("status_id") @Encrypt Long statusId) {
        return new ResponseEntity<>(statusService.queryStatusById(organizationId, statusId), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询状态机下的所有状态")
    @PostMapping(value = "/organizations/{organization_id}/status/query_by_state_machine_id")
    public ResponseEntity<List<StatusVO>> queryByStateMachineIds(@PathVariable("organization_id") Long organizationId,
                                                                 @RequestBody @Valid List<Long> stateMachineIds) {
        return new ResponseEntity<>(statusService.queryByStateMachineIds(organizationId, stateMachineIds), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询组织下的所有状态")
    @GetMapping(value = "/organizations/{organization_id}/status/query_all")
    public ResponseEntity<List<StatusVO>> queryAllStatus(@PathVariable("organization_id") Long organizationId) {
        return new ResponseEntity<>(statusService.queryAllStatus(organizationId), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询组织下的所有状态,返回map")
    @GetMapping(value = "/organizations/{organization_id}/status/list_map")
    public ResponseEntity<Map<Long, StatusVO>> queryAllStatusMap(
            @ApiParam(value = "组织id", required = true)
            @PathVariable("organization_id") Long organizationId) {
        return new ResponseEntity<>(statusService.queryAllStatusMap(organizationId), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "校验状态名字是否未被使用")
    @GetMapping(value = "/organizations/{organization_id}/status/check_name")
    public ResponseEntity<StatusCheckVO> checkName(@PathVariable("organization_id") Long organizationId,
                                                   @RequestParam("name") String name) {
        return Optional.ofNullable(statusService.checkName(organizationId, name))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.statusName.check"));

    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "校验状态名字是否未被使用,项目层")
    @GetMapping(value = "/projects/{project_id}/status/project_check_name")
    public ResponseEntity<StatusCheckVO> checkNameOnPro(@PathVariable("project_id") Long projectId,
                                                        @RequestParam("organization_id") Long organizationId,
                                                        @RequestParam("name") String name) {
        return Optional.ofNullable(statusService.checkName(organizationId, name))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.statusName.check"));
    }


    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查看项目拥有的状态")
    @PostMapping(value = "/projects/{project_id}/status/list_status")
    public ResponseEntity<Page<ProjectStatusVO>> listStatusByProjectId(@PathVariable("project_id") Long projectId,
                                                                       @SortDefault(value = "id", direction = Sort.Direction.DESC) PageRequest pageRequest,
                                                                       @ApiParam(value = "status search dto", required = true)
                                                                       @RequestBody StatusSearchVO statusSearchVO) {
        return new ResponseEntity<>(statusService.listStatusByProjectId(projectId, pageRequest, statusSearchVO), HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "删除项目的状态")
    @DeleteMapping(value = "/projects/{project_id}/status/delete_status")
    public ResponseEntity deleteStatus(@PathVariable("project_id") Long projectId,
                                       @RequestParam @Encrypt Long statusId,
                                       @RequestParam String applyType,
                                       @RequestBody List<DeleteStatusTransferVO> statusTransferVOS) {
        statusService.deleteStatus(projectId,statusId,applyType, statusTransferVOS);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "校验删除的需要选择转换状态的问题类型")
    @GetMapping(value = "/projects/{project_id}/status/check_delete_status")
    public ResponseEntity<List<IssueTypeVO>> checkDeleteStatus(@PathVariable("project_id") Long projectId,
                                                               @RequestParam String applyType,
                                                               @RequestParam @Encrypt Long statusId) {
        return new ResponseEntity<>(statusService.checkDeleteStatus(projectId, applyType, statusId), HttpStatus.OK);
    }
}
