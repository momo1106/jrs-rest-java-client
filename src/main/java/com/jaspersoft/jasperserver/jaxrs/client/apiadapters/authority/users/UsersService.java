/*
 * Copyright (C) 2005 - 2014 Jaspersoft Corporation. All rights  reserved.
 * http://www.jaspersoft.com.
 *
 * Unless you have purchased  a commercial license agreement from Jaspersoft,
 * the following license terms  apply:
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License  as
 * published by the Free Software Foundation, either version 3 of  the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero  General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public  License
 * along with this program.&nbsp; If not, see <http://www.gnu.org/licenses/>.
 */

package com.jaspersoft.jasperserver.jaxrs.client.apiadapters.authority.users;

import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.AbstractAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.core.SessionStorage;

public class UsersService extends AbstractAdapter {
    private String organizationId;

    public UsersService(SessionStorage sessionStorage) {
        super(sessionStorage);
    }

    public UsersService organization(String organizationId) {
        if ("".equals(organizationId) || "/".equals(organizationId)) {
            throw new IllegalArgumentException("'organizationId' mustn't be an empty string");
        }
        this.organizationId = organizationId;
        return this;
    }

    @Deprecated
    public SingleUserRequestAdapter username(String username) {
        if ("".equals(username) || "/".equals(username)) {
            throw new IllegalArgumentException("'username' mustn't be an empty string");
        }
        return new SingleUserRequestAdapter(sessionStorage, organizationId, username);
    }

    public SingleUserRequestAdapter user() {
        return new SingleUserRequestAdapter(sessionStorage, organizationId);
    }

    public SingleUserRequestAdapter user(String userId) {
        return new SingleUserRequestAdapter(userId, organizationId, sessionStorage);
    }

    public BatchUsersRequestAdapter allUsers() {
        return new BatchUsersRequestAdapter(sessionStorage, organizationId);
    }
}
