/*
 * Copyright [2016]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netpet.spools.javacore.httplite.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-5-27
 * Time: 上午9:26
 */
public class Entry {
    public static void main(String[] args) {
        try
        {
            // Listen at the specified port.
            ServerSocket server = new ServerSocket(8080);

            for (;;)
            {
                // Accept an incoming connection.
                Socket client = server.accept();
                // Write "Hello, world!" to the client.
                client.getOutputStream().write("Hello, world!\r\n".getBytes());
                // Close the connection.
                client.close();
            }
        }
        catch (IOException e)
        {
            System.err.println("Error binding the specified port.");
        }
    }
}
