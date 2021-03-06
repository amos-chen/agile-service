package io.choerodon.agile.infra.enums;

import io.choerodon.agile.api.vo.PageConfigFieldEditedVO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author superlee
 * @since 2020-08-19
 */
public class SystemFieldCanNotEdit {

    private SystemFieldCanNotEdit() {}

    public static Map<String, PageConfigFieldEditedVO> fieldEdited(String issueType) {
        return  buildByIssueType(issueType);
    }

    private static Map<String, PageConfigFieldEditedVO> buildByIssueType(String issueType) {
        if (ObjectSchemeFieldContext.EPIC.equals(issueType)) {
            return epicMap;
        } else if (ObjectSchemeFieldContext.STORY.equals(issueType)) {
            return storyMap;
        } else if (ObjectSchemeFieldContext.TASK.equals(issueType)
                || ObjectSchemeFieldContext.SUB_TASK.equals(issueType)) {
            return taskMap;
        } else if (ObjectSchemeFieldContext.BUG.equals(issueType)) {
            return bugMap;
        } else {
            return null;
        }
    }

    private static Map<String, PageConfigFieldEditedVO> epicMap;
    private static Map<String, PageConfigFieldEditedVO> storyMap;
    private static Map<String, PageConfigFieldEditedVO> taskMap;
    private static Map<String, PageConfigFieldEditedVO> bugMap;

    static {
        epicMap = new HashMap<>();
        epicMap.put(FieldCode.ISSUE_TYPE, new PageConfigFieldEditedVO(true, true, true));
        epicMap.put(FieldCode.STATUS, new PageConfigFieldEditedVO(true, true, true));
        epicMap.put(FieldCode.SUMMARY, new PageConfigFieldEditedVO(true, true, true));
        epicMap.put(FieldCode.PRIORITY, new PageConfigFieldEditedVO(true, true, true));
        epicMap.put(FieldCode.EPIC_NAME, new PageConfigFieldEditedVO(true, true, true));
        epicMap.put(FieldCode.ASSIGNEE, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.DESCRIPTION, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.CREATION_DATE, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.LAST_UPDATE_DATE, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.SPRINT, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.COMPONENT, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.FIX_VERSION, new PageConfigFieldEditedVO(false, true, true));
        epicMap.put(FieldCode.INFLUENCE_VERSION, new PageConfigFieldEditedVO(false, true, true));

        storyMap = new HashMap<>();
        storyMap.put(FieldCode.ISSUE_TYPE, new PageConfigFieldEditedVO(true, true, true));
        storyMap.put(FieldCode.PRIORITY, new PageConfigFieldEditedVO(true, true, true));
        storyMap.put(FieldCode.SUMMARY, new PageConfigFieldEditedVO(true, true, true));
        storyMap.put(FieldCode.REPORTER, new PageConfigFieldEditedVO(true, true, true));
        storyMap.put(FieldCode.DESCRIPTION, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.ASSIGNEE, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.EPIC, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.SPRINT, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.CREATION_DATE, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.LAST_UPDATE_DATE, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.INFLUENCE_VERSION, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.FIX_VERSION, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.STORY_POINTS, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.REMAINING_TIME, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.TIME_TRACE, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.COMPONENT, new PageConfigFieldEditedVO(false, true, true));
        storyMap.put(FieldCode.STATUS, new PageConfigFieldEditedVO(true, true, true));


        taskMap = new HashMap<>();
        taskMap.put(FieldCode.ISSUE_TYPE, new PageConfigFieldEditedVO(true, true, true));
        taskMap.put(FieldCode.PRIORITY, new PageConfigFieldEditedVO(true, true, true));
        taskMap.put(FieldCode.SUMMARY, new PageConfigFieldEditedVO(true, true, true));
        taskMap.put(FieldCode.REPORTER, new PageConfigFieldEditedVO(true, true, true));
        taskMap.put(FieldCode.DESCRIPTION, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.ASSIGNEE, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.EPIC, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.SPRINT, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.FIX_VERSION, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.INFLUENCE_VERSION, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.REMAINING_TIME, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.CREATION_DATE, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.LAST_UPDATE_DATE, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.TIME_TRACE, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.COMPONENT, new PageConfigFieldEditedVO(false, true, true));
        taskMap.put(FieldCode.STATUS, new PageConfigFieldEditedVO(true, true, true));


        bugMap = new HashMap<>();
        bugMap.put(FieldCode.ISSUE_TYPE, new PageConfigFieldEditedVO(true, true, true));
        bugMap.put(FieldCode.PRIORITY, new PageConfigFieldEditedVO(true, true, true));
        bugMap.put(FieldCode.SUMMARY, new PageConfigFieldEditedVO(true, true, true));
        bugMap.put(FieldCode.REPORTER, new PageConfigFieldEditedVO(true, true, true));
        bugMap.put(FieldCode.DESCRIPTION, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.ASSIGNEE, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.EPIC, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.SPRINT, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.INFLUENCE_VERSION, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.FIX_VERSION, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.REMAINING_TIME, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.CREATION_DATE, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.LAST_UPDATE_DATE, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.TIME_TRACE, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.COMPONENT, new PageConfigFieldEditedVO(false, true, true));
        bugMap.put(FieldCode.STATUS, new PageConfigFieldEditedVO(true, true, true));

    }

}
