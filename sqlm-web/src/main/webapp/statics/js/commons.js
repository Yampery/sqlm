/**
 * 工具js
 * Created by Yampery on 2017/9/13.
 */

/********************* 通用工具 ******************/
/**
 * 判断是参数否为""/空格/undefined/null
 * @param arg1
 * @returns
 */
function isNull(str){
    var isNull = false;
    if (null == str || !str)
        isNull = true;
    else if("" == str || 1 > str.length) {
        isNull = true;
    }
    else if(null == JSON.stringify(str))
        isNull = true;
    return isNull;
}

function trimToEmpty(str) {
    return isNull(str) ? "" : str.trim();
}