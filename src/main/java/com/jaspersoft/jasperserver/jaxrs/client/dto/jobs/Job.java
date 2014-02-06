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

package com.jaspersoft.jasperserver.jaxrs.client.dto.jobs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Job {

    private String baseOutputFilename;
    private RepositoryDestination repositoryDestination;
    private String description;
    private long id;
    private String label;
    private MailNotification mailNotification;

    @XmlElementWrapper(name = "outputFormats")
    @XmlElement(name = "outputFormat")
    private List<String> outputFormats;

    private String outputLocale;
    private String reportUnitURI;

    @XmlElements({
            @XmlElement(name = "simpleTrigger", type = SimpleTrigger.class),
            @XmlElement(name = "calendarTrigger", type = CalendarTrigger.class)})
    private JobTrigger jobTrigger;

}