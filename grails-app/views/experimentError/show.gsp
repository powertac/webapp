
<%@ page import="edu.kit.iism.experimentcenter.ExperimentError" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show ExperimentError</title>
        <g:javascript library="shCore" />
        <g:javascript library="shBrushGroovy" />
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'shCore.css')}" />
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'shThemeDefault.css')}" />
        <script type="text/javascript">
          SyntaxHighlighter.config.clipboardSwf = "${createLinkTo(dir:'js',file:'clipboard.swf')}";
          SyntaxHighlighter.all();
        </script>
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
            <h1>Show ExperimentError</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentErrorInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Experiment:</td>
                            
                            <td valign="top" class="value"><g:link controller="experiment" action="show" id="${experimentErrorInstance?.experiment?.id}">${experimentErrorInstance?.experiment?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Log Level:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentErrorInstance, field:'logLevel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Message:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentErrorInstance, field:'errorMessage')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Throwable:</td>
                            
                            <td valign="top" class="value">
                              <pre class="brush: groovy; tab-size: 2">${experimentErrorInstance?.errorStack}</pre>
                            </td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentErrorInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${experimentErrorInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
