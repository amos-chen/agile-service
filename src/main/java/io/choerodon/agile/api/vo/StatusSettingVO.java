package io.choerodon.agile.api.vo;

import io.choerodon.agile.infra.dto.StatusTransferSettingDTO;
import org.hzero.starter.keyencrypt.core.Encrypt;

import java.util.List;

/**
 * @author zhaotianxin
 * @date 2020-08-12 13:26
 */
public class StatusSettingVO {
    @Encrypt
    private Long id;

    private String name;

    private String code;

    private String type;

    private Long objectVersionNumber;

    private List<StatusTransferSettingVO> statusTransferSettingVOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public List<StatusTransferSettingVO> getStatusTransferSettingVOS() {
        return statusTransferSettingVOS;
    }

    public void setStatusTransferSettingVOS(List<StatusTransferSettingVO> statusTransferSettingVOS) {
        this.statusTransferSettingVOS = statusTransferSettingVOS;
    }
}