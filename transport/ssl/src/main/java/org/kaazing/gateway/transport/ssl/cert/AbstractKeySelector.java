/**
 * Copyright 2007-2016, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.transport.ssl.cert;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Collection;

import org.kaazing.gateway.resource.address.ResourceAddress;
import org.kaazing.gateway.transport.TransportKeySelector;

public abstract class AbstractKeySelector implements TransportKeySelector {

    @Override
    public ResourceAddress getAvailableCertAliasesKey(boolean clientMode) {
        return null;
    }

    @Override
    public Collection<String> getAvailableCertAliases(boolean clientMode) {
        return null;
    }

    @Override
    public void bind(ResourceAddress resourceAddress)
        throws Exception {
    }

    @Override
    public void unbind(ResourceAddress resourceAddress) throws Exception {
    }

    @Override
    public void connect(ResourceAddress resourceAddress)
        throws Exception {
    }

    public void init(KeyStore keyStore, String keyStorePassword)
        throws KeyStoreException {
        char[] storePassword = null;
        if (keyStorePassword != null) {
            storePassword = keyStorePassword.toCharArray();
        }

        init(keyStore, storePassword);
    }

    public abstract void init(KeyStore keyStore, char[] keyStorePassword) throws KeyStoreException;
}
