<g:isLoggedIn>
<ul class="avmenu">
  <li><g:link controller="experiment" action="list">Experiment Control</g:link>
    <ul>
      <li><g:link class="list" controller="series" action="list">Experiment Series</g:link></li>
      <ul>
        <li><g:link class="list" controller="experiment" action="list">Experiments</g:link></li>
      </ul>
      <li><g:link class="list" controller="workerClient" action="list">Experiment Runners</g:link></li>
    </ul>
  </li>
  <li><a href="#">Experiment Results</a>
    <%--
    <div class="announce">
      <h3>Data filter:</h3>
      <g:select optionKey="id" from="${edu.kit.iism.experimentcenter.Experiment.list()}" name="experiment.id" value="${tradeLogInstance?.experiment?.id}" noSelection="${['null':'All Experiments']}"></g:select>
    </div>
    --%>
    <ul>
      <li><g:link class="list" controller="report" action="list">Reports</g:link></li>
    </ul>
  </li>
  <g:ifAnyGranted role="ROLE_ADMIN">
    <li><a href="#">Administration</a>
      <ul>
        <li><g:link class="list" controller="runtimeLogging">Manage Logging</g:link></li>
        <li><g:link class="list" controller="user" action="list">Manage users</g:link></li>
        <li><g:link class="list" controller="role" action="list">Manage roles</g:link></li>
      </ul>
    </li>
  </g:ifAnyGranted>
  <li><a class="controller" href="https://bugs.launchpad.net/microgridmarket" target="_blank">Report Bugs</a></li>
</ul>
</g:isLoggedIn>
<div class="announce">
  <g:isLoggedIn>
    <p class="userdata">
      <strong>Logged in as:</strong><br/>
      <g:loggedInUserInfo field="userRealName">Guest User</g:loggedInUserInfo> <g:link controller="user" action="show" id="${loggedInUserInfo(field:'id')}">[Details]</g:link></small>
    </p>
    <p class="userdata">
    <g:link controller="logout">Logout</g:link>
    </p>
  </g:isLoggedIn>
  <g:isNotLoggedIn>
    <form action='${request.contextPath}/j_spring_security_check' method='POST' id='loginForm'>
      <p>
					<label for='j_username'>Login</label><br/>
					<input type='text' size='10' maxlength='15' name='j_username' id='j_username'  />
				</p>
				<p>
					<label for='j_password'>Password</label><br/>
					<input type='password' size='10' maxlength='15' name='j_password' id='j_password' />
				</p>
				<p>
					<label for='remember_me'>Remember me</label>
					<input type='checkbox' class='chk' id='remember_me' name='_spring_security_remember_me'>
				</p>
				<p>
					<input type='submit' value='Login' />
				</p>
    </form>
  </g:isNotLoggedIn>
</div>

