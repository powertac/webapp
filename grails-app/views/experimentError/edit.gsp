
<%@ page import="edu.kit.iism.experimentcenter.ExperimentError" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ExperimentError</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="home" controller="experiment" action="list">Experiments</g:link></span>
            <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
            <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">ExperimentError List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ExperimentError</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ExperimentError</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${experimentErrorInstance}">
            <div class="errors">
                <g:renderErrors bean="${experimentErrorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${experimentErrorInstance?.id}" />
                <input type="hidden" name="version" value="${experimentErrorInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="experiment">Experiment:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:experimentErrorInstance,field:'experiment','errors')}">
                                    <g:select optionKey="id" from="${edu.kit.iism.experimentcenter.Experiment.list()}" name="experiment.id" value="${experimentErrorInstance?.experiment?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="logLevel">Log Level:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:experimentErrorInstance,field:'logLevel','errors')}">
                                    <input type="text" maxlength="128" id="logLevel" name="logLevel" value="${fieldValue(bean:experimentErrorInstance,field:'logLevel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="message">Message:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:experimentErrorInstance,field:'errorMessage','errors')}">
                                    <textarea rows="5" cols="40" name="message">${fieldValue(bean:experimentErrorInstance, field:'errorMessage')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="throwable">Throwable:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:experimentErrorInstance,field:'errorStack','errors')}">
                                    <textarea rows="5" cols="40" name="throwable">${fieldValue(bean:experimentErrorInstance, field:'errorStack')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:experimentErrorInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${experimentErrorInstance?.dateCreated}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
