package com.sqlm.validator.group;

import javax.validation.GroupSequence;

/**
 * @decription Group
 * <p>定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验</p>
 * @author Yampery
 * @date 2017/9/13 16:44
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}
