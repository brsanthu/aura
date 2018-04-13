/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
({

    init: function(cmp) {
        var testName = cmp.get("v.name");
        if (testName && testName.indexOf("test") === 0) {
            var shortName = testName.substring(4);
            cmp.set("v.title", shortName);
        } else {
            cmp.set("v.title", testName);
        }
        cmp.set("v.individualUrl", $A.getContext().getContextPath()
            + "/aurajstest/jstest.app?test=" + cmp.get("v.name")
            + "&descriptor=" + cmp.get("v.bundle")
            + "&aura.mode=AUTOJSTESTDEBUG&aura.testReset=true");
    },

    runTest : function(cmp, evt, helper){
        helper.runTest(cmp);
    },

    rerun : function(cmp, evt, helper){
        helper.unloadTestContent(cmp);
        helper.loadTest(cmp);
    },

    onActivate: function(cmp, evt, helper) {
        helper.loadTest(cmp);
    }
})// eslint-disable-line semi
