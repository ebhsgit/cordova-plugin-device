/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova.device;

import com.eightbhs.core.util.DeviceInfo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device extends CordovaPlugin {
    public static final String TAG = "Device";

    /**
     * Constructor.
     */
    public Device() {
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action          The action to execute.
     * @param args            JSONArry of arguments for the plugin.
     * @param callbackContext The callback id used when calling back into JavaScript.
     * @return True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getDeviceInfo".equals(action)) {
            JSONObject r = new JSONObject();
            r.put("uuid", DeviceInfo.instance.getDeviceId());
            r.put("version", DeviceInfo.instance.getOsVersion());
            r.put("platform", DeviceInfo.instance.getPlatform());
            r.put("model", DeviceInfo.instance.getModel());
            r.put("manufacturer", DeviceInfo.instance.getManufacturer());
            r.put("isVirtual", DeviceInfo.instance.isVirtual());
            r.put("serial", DeviceInfo.instance.getSerial());
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }
}
