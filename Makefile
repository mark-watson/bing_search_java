jar:
	(cd out/production/bing_search_java; jar xvf ../../../lib/commons-codec-1.4.jar)
	(cd out/production/bing_search_java; jar xvf ../../../lib/microsoft-translator-java-api-0.6.1-jar-with-dependencies.jar)
	(cd out/production/bing_search_java; jar cvf ../../../bing.jar *)

local_maven_install:
	lein localrepo install bing.jar local/bing 0.1.0

local_maven_list:
	lein localrepo list | grep bing



