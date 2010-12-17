
<%@ page import="edu.kit.iism.experimentcenter.enumerations.ExperimentStatus; edu.kit.iism.experimentcenter.Experiment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Experiment</title>
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
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Experiment List</g:link></span>
            <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Experiment</g:link></span>
        </div>
        <div class="body">
            <h1>Show Experiment</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">Series:</td>

                            <td valign="top" class="value">
                              <g:if test="${experimentInstance?.series}">
                                <g:link controller="series" action="show" id="${experimentInstance?.series?.id ?: ''}">${fieldValue(bean:experimentInstance, field:'series')?:'--none--'}</g:link>
                              </g:if>
                              <g:else>
                                ${fieldValue(bean:experimentInstance, field:'series')?:'--none--'}
                              </g:else>
                            </td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'name')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>

                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'description')}</td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Experiment Status:</td>
                            
                            <td valign="top" class="value">${experimentInstance?.experimentStatus?.encodeAsHTML()}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Worker Client:</td>

                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'targetMachine')}</td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Min. Version Worker Client:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'minVersionExperimentRunner')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Max. Version Worker Client:</td>

                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'maxVersionExperimentRunner')}</td>

                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:experimentInstance, field:'lastUpdated')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td colspan="2" valign="top" class="name">Experiment Configuration:</td>
                        </tr>

                        <tr class="prop">
                            <td colspan="2" valign="top" class="value">
                              <pre class="brush: groovy; tab-size: 2; collapse: true">${experimentInstance?.experimentConfiguration}</pre>
                            </td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Experiment Errors:</td>

                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="e" in="${experimentInstance.experimentErrors}">
                                    <li><g:link controller="experimentError" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>

                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${experimentInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                    <span class="button"><g:actionSubmit class="edit" onclick="return confirm('Reset Experiment?');" value="Reset" /></span>
                    <span class="button"><g:actionSubmit class="edit" onclick="return confirm('Duplicate Experiment?');" value="Duplicate" /></span>
                    <g:if test="${experimentInstance?.experimentStatus == ExperimentStatus.Paused}">
                      <span class="button"><g:actionSubmit class="edit" onclick="return confirm('Activate Experiment?');" value="Activate" /></span>
                    </g:if>
                    <g:else>
                      <span class="button"><g:actionSubmit class="edit" onclick="return confirm('Pause Experiment?');" value="Pause" /></span>
                    </g:else>
                </g:form>
            </div>
        </div>
    </body>
</html>
