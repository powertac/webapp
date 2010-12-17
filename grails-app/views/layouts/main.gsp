<html>
<head>
  <title><g:layoutTitle default="IISM Experiment Center"/></title>
  <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
  <link rel="shortcut icon" href="${createLinkTo(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
  <g:layoutHead/>
  <g:javascript library="application"/>
</head>
<body>
<div id="spinner" class="spinner" style="display:none;">
  <img src="${createLinkTo(dir: 'images', file: 'spinner.gif')}" alt="Spinner"/>
</div>
<div id="wrap">
  <div id="header">
    <a href="${createLinkTo(dir: '')}"><img src="${createLinkTo(dir: 'images', file: 'header.jpg')}" alt="IISM Experiment Center Beta"/></a>
    <h1><a class="home" href="${createLinkTo(dir: '')}">IISM Experiment Center <i>Beta</i></a></h1>
  </div>
  <div id="leftside">
    <g:render template="/sidebar"/>
  </div>

  <div id="content">
    <g:layoutBody/>
  </div>
  <div id="footer">
    <p>System Time: ${new Date()} &middot; System Version: <a href="https://launchpad.net/microgridmarket" target="_blank"><g:meta name="app.version"/></a></p>
    <p>Copyright &copy; 2007-2010 <a href="http://www.iism.uni-karlsruhe.de" target="_blank">Institute of Information Systems and Management (IISM)</a>, <a href="http://www.kit.edu" target="_blank">Karlsruhe Institute of Technology (KIT)</a></p>
  </div>
</div>
</body>
</html>