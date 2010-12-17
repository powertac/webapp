
<%@ page import="edu.kit.iism.experimentcenter.WorkerClient" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show WorkerClient</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="home" controller="experiment" action="list">Experiments</g:link></span>
            <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">WorkerClient List</g:link></span>
        </div>
        <div class="body">
            <h1>Show WorkerClient</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Host Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'hostName')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Remote Host:</td>

                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'remoteHost')}</td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ip Address:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'ipAddress')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Port:</td>

                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'port')}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">App Version:</td>

                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'appVersion')}</td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Worker Status:</td>
                            
                            <td valign="top" class="value">${workerClientInstance?.workerStatus?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Enabled:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'enabled')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Online:</td>
                            
                            <td valign="top" class="value">
                              <g:if test="${workerClientInstance?.online}">
                                <img src="${createLinkTo(dir: 'images', file: 'online.png')}" width="20px" alt="Online"/>
                              </g:if>
                              <g:else>
                                <img src="${createLinkTo(dir: 'images', file: 'offline.png')}" width="20px" alt="Offline"/>
                              </g:else>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Seen:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'lastSeen')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Os Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'osName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Os Arch:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'osArch')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Os Version:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'osVersion')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Java Vendor:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'javaVendor')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Java Version:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'javaVersion')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'userName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User Language:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'userLanguage')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:workerClientInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
