#%Module######################################################################
##
##      Project Module
##
proc ModulesHelp { } {
  puts stderr "\tThe TGFS-CG Project Module\n"
  puts stderr "\tThis module loads PATHs and variables for accessing Verilator."
}


#set distro [exec /bin/lsb_release -i -s]
#if { $distro == "CentOS" && ![info exists ::env(PROJECT)] && ![info exists ::env(PCP_DIR)] } {
#    puts stderr     "Don't forget to execute 'scl enable devtoolset-7 bash'"
#}

if {![info exists ::env(PROJECT)] && [file exists $::env(HOME)/.sdkman/candidates/java/17.0.2-open/] != 1} { 
    puts stderr "Please install java via 'sdk install java 17.0.2-open'!"
    prereq java/17.0.2
} else {
    prepend-path PATH $::env(HOME)/.sdkman/candidates/java/17.0.2-open/bin
}

setenv PROJECT RDL-Editor

