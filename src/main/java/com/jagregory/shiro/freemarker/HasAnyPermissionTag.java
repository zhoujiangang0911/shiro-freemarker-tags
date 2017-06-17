package com.jagregory.shiro.freemarker;

import org.apache.shiro.subject.Subject;

/**
 * Created by zhougj77 on 2017-06-17.
 * zhoqjg77@163.com
 */
public class HasAnyPermissionTag   extends PermissionTag {
    private static final String PERMISSION_NAMES_DELIMETER = ",";

    public HasAnyPermissionTag() {
    }

    protected boolean showTagBody(String pNames) {
        boolean hasAnyPerm = false;
        Subject subject = this.getSubject();
        if(subject != null) {
            String[] arr$ = pNames.split(",");
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String p = arr$[i$];
                if(subject.isPermitted(p.trim())) {
                    return true;
                }
            }
        }

        return hasAnyPerm;
    }
}
