package com.droidwolf.andmon1.example;
/*
 * Copyright (c) 2015 droidwolf(droidwolf2006@gmail.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.droidwolf.libandmon;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("droidwolf_mon", MyService.class.getSimpleName() + ":onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                libandmon.start(MyService.this, android.os.Process.myPid(), MyService.class, "http://my.oschina.net/droidwolf/blog", true);
            }
        }).start();

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
