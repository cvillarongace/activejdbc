/*
Copyright 2009-2019 Igor Polevoy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.javalite.db_migrator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javalite.common.RuntimeUtil;
import org.javalite.common.Util;

public abstract class AbstractIntegrationSpec {

    protected String execute(String dir, String... args){

            List<String> argsList =  new ArrayList<>(Arrays.asList(args));
            System.out.println("TEST MAVEN EXECUTION START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("-->> Executing: mvn " + Util.join(args, " "));

            RuntimeUtil.Response response =  RuntimeUtil.execute(2048, new File(dir), "mvn " + Util.join(argsList, " "));

            String out = response.out;
            String err = response.err;

            System.out.println();
            System.out.print("Exit code: ");
            System.out.println(response.exitValue);
            System.out.print(response.out);
            System.err.println(response.err);
            System.out.println("TEST MAVEN EXECUTION END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            return out + err;
    }
}
