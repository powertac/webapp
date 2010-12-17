security {

	// see DefaultSecurityConfig.groovy for all settable/overridable properties

	active = true

	loginUserDomainClass = "User"
	authorityDomainClass = "Role"
	useRequestMapDomainClass = false

   requestMapString = '''
    CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON
    PATTERN_TYPE_APACHE_ANT

    /login/**=IS_AUTHENTICATED_ANONYMOUSLY

    /rest*=IS_AUTHENTICATED_ANONYMOUSLY
    /rest/**=IS_AUTHENTICATED_ANONYMOUSLY

    /accountentry*=IS_AUTHENTICATED_REMEMBERED
    /accountentry/**=IS_AUTHENTICATED_REMEMBERED

    /timeslotrating*=IS_AUTHENTICATED_REMEMBERED
    /timeslotrating/**=IS_AUTHENTICATED_REMEMBERED

    /blockshout*=IS_AUTHENTICATED_REMEMBERED
    /blockshout/**=IS_AUTHENTICATED_REMEMBERED

    /experiment*=IS_AUTHENTICATED_REMEMBERED
    /experiment/**=IS_AUTHENTICATED_REMEMBERED

    /experimenterror*=IS_AUTHENTICATED_REMEMBERED
    /experimenterror/**=IS_AUTHENTICATED_REMEMBERED

    /quote*=IS_AUTHENTICATED_REMEMBERED
    /quote/**=IS_AUTHENTICATED_REMEMBERED

    /shout*=IS_AUTHENTICATED_REMEMBERED
    /shout/**=IS_AUTHENTICATED_REMEMBERED

    /stockentry*=IS_AUTHENTICATED_REMEMBERED
    /stockentry/**=IS_AUTHENTICATED_REMEMBERED

    /timeslot*=IS_AUTHENTICATED_REMEMBERED
    /timeslot/**=IS_AUTHENTICATED_REMEMBERED

    /tradelog*=IS_AUTHENTICATED_REMEMBERED
    /tradelog/**=IS_AUTHENTICATED_REMEMBERED

    /tradingagent*=IS_AUTHENTICATED_REMEMBERED
    /tradingagent/**=IS_AUTHENTICATED_REMEMBERED

    /workerclient/list*=IS_AUTHENTICATED_REMEMBERED
    /workerclient/list/**=IS_AUTHENTICATED_REMEMBERED
    /workerclient/show*=IS_AUTHENTICATED_REMEMBERED
    /workerclient/show/**=IS_AUTHENTICATED_REMEMBERED
    /workerclient*=ROLE_ADMIN
    /workerclient/**=ROLE_ADMIN

    /user*=IS_AUTHENTICATED_REMEMBERED
    /user/list*=ROLE_ADMIN
    /user/list/**=ROLE_ADMIN
    /user/create*=ROLE_ADMIN
    /user/create/**=ROLE_ADMIN
    /user/save*=ROLE_ADMIN
    /user/save/**=ROLE_ADMIN
    /user/show*=IS_AUTHENTICATED_REMEMBERED
    /user/show/**=IS_AUTHENTICATED_REMEMBERED
    /user/edit*=IS_AUTHENTICATED_REMEMBERED
    /user/edit/**=IS_AUTHENTICATED_REMEMBERED
    /user/update*=IS_AUTHENTICATED_REMEMBERED
    /user/update/**=IS_AUTHENTICATED_REMEMBERED
    /user/delete*=ROLE_ADMIN
    /user/delete/**=ROLE_ADMIN
    /user*=IS_AUTHENTICATED_REMEMBERED
    /user/**=IS_AUTHENTICATED_REMEMBERED

    /role*=ROLE_ADMIN
    /role/**=ROLE_ADMIN

    /runtimelogging*=ROLE_ADMIN
    /runtimelogging/**=ROLE_ADMIN
    '''
}
