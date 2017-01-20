DEPENDS += "u-boot-mkenvimage-native"

#Env binary size
ENV_SIZE = "4096"

#Env base Name
ENV_BASE_NAME ??= "${UBOOT_CONFIG}"

# Env base file correspond to common part of all environment
ENV_BASE_FILE = "${WORKDIR}/${ENV_BASE_NAME}.env"

do_environment_mkimage() {
	if  [ -e "${WORKDIR}/${ENV_BASE_NAME}.env" ]; then
		mkenvimage -s ${ENV_SIZE} -o ${WORKDIR}/${ENV_BASE_NAME}.bin ${WORKDIR}/${ENV_BASE_NAME}.env
	fi
}

do_deploy_append() {

    if [ -e "${WORKDIR}/${ENV_BASE_NAME}.bin" ]; then
	install -d ${DEPLOYDIR}
    	install -m 644 ${WORKDIR}/${ENV_BASE_NAME}.bin ${DEPLOYDIR}/u-boot-env-${ENV_BASE_NAME}.bin
    fi
}

addtask environment_mkimage after do_compile before do_deploy
