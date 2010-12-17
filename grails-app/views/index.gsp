<html>
<head>
  <title>Welcome to the IISM Experiment Center</title>
  <meta name="layout" content="main"/>
</head>
<body>
<h1 style="width: 400px; margin: 8px 0 20px 20px;">Welcome to the IISM Experiment Center</h1>
<g:isNotLoggedIn>
  <p style="width: 400px; margin: 8px 0 0 20px; text-align:justify;">
    This service is the central dispatcher for conducting E-Energy market simulations. Please log in to use the
    experiment center. If you do not have a user account or if you forgot your user name or password please contact
    <a href="http://www.im.uni-karlsruhe.de/block" target="_blank">Carsten Block</a>.
  </p>
</g:isNotLoggedIn>
<g:isLoggedIn>
  <p style="width: 400px; margin: 8px 0 0 20px; text-align:justify;">
    This service is the central dispatcher for conducting E-Energy market simulations. Please use the navigation menu on
    the left to create, run, and evaluate your experiments.
  </p>
  <p style="width: 400px; margin: 8px 0 0 20px; text-align:justify;">
    If you are not sure what to do next you may start by simply
    <g:link class="list" controller="experiment" action="create">creating a new experiment</g:link>. After you've
    accomplished this step, make sure that the experiment of your experiment is set to &quot;Pending&quot;. To accomplish
    this you may simply click the &quot;Activate&quot; button in the
    <g:link class="list" controller="experiment" action="list">experiment overview</g:link>.
  </p>
  <p style="width: 400px; margin: 8px 0 0 20px; text-align:justify;">
    Your experiment is now queued for execution and picked up by an
    <g:link class="list" controller="workerClient">experiment runner</g:link> as soon as possible. Eventually an
    experiment runner will pick up your experiment and execute it according to the experiment configuration you've
    supplied while creating the experiment. Once runner has finished the experiment it will report all data that was
    collected during the experiment's execution back to this experiment center. It is stored right here so that you may
    view or export it to your local machine whenever you like.
  <p style="width: 400px; margin: 8px 0 0 20px; text-align:justify;">
    In order to view e.g. the <g:link class="list" controller="tradeLog" action="list">transaction log</g:link> for your
    experiment please click on the respective link in the menu on the left.
  </p>
</g:isLoggedIn>
</body>
</html>