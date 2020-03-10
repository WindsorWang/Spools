/*
 * Copyright [2020]
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

package com.netpet.spools.javadp.behavioral.templatemethod;

import java.util.LinkedList;
import java.util.List;

public abstract class Application {

    private List<Document> docs = new LinkedList<>();

    public void addDocument(Document document) {
        docs.add(document);
    }

    public void openDocument(String name) {
        if (!canOpenDocument(name)) {
            // cannot handle this document
            return;
        }

        Document doc = this.doCreateDocument();
        if (doc != null) {
            this.addDocument(doc);
            aboutToOpenDocument(doc);
            doc.open();
            doc.doRead();
        }
    }

    public abstract Document doCreateDocument();

    public abstract boolean canOpenDocument(String name);

    public abstract void aboutToOpenDocument(Document document);

}
