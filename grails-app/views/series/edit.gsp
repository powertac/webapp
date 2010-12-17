
<%@ page import="edu.kit.iism.experimentcenter.Series" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'series.label', default: 'Series')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${seriesInstance}">
            <div class="errors">
                <g:renderErrors bean="${seriesInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${seriesInstance?.id}" />
                <g:hiddenField name="version" value="${seriesInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="series.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: seriesInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${seriesInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="experiments"><g:message code="series.experiments.label" default="Experiments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: seriesInstance, field: 'experiments', 'errors')}">
                                    
<ul>
<g:each in="${seriesInstance?.experiments?}" var="e">
    <li><g:link controller="experiment" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="experiment" action="create" params="['series.id': seriesInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'experiment.label', default: 'Experiment')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
