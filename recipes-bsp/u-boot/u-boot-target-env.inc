# Handle severals environments generation for u-boot

#Env binary size
ENV_SIZE = "0x1000"

ENV_BIN_DIR = "${WORKDIR}/target_env_bin"

# Env deploy dir is the name of directory where binary envs will be deployed
ENV_DEPLOY_DIR="u-boot-envs"

# Env deploy src dir is the name of directory where txt envs will be deployed
ENV_SRC_DEPLOY_DIR="u-boot-envs-src"

do_build_mkimage_tool () {
   HOSTCC="${CC}" HOSTLD="${LD}" HOSTLDFLAGS="${LDFLAGS}" HOSTSTRIP=true oe_runmake  sandbox_defconfig 
   HOSTCC="${CC}" HOSTLD="${LD}" HOSTLDFLAGS="${LDFLAGS}" HOSTSTRIP=true oe_runmake  tools
}

python do_environment_mkimage() {
    import subprocess
    import shutil
    # list env variant target files
    target_root_dir = d.getVar('WORKDIR',True)
    # env files only for UBOOT_CONFIG
    env_uboot_config = d.getVar('UBOOT_CONFIG',True)
    env_files = []
    for f in os.listdir(target_root_dir):
        if f.endswith(".env"):
            env_files.append(os.path.join(target_root_dir,f))
    env_bin_dir = d.getVar("ENV_BIN_DIR",True)
    # cleans if it exists env_bin directory
    shutil.rmtree(env_bin_dir, ignore_errors=True)
    # create env bin directory
    os.mkdir(env_bin_dir)
    print 'Building binary environments in : %s' % env_bin_dir
    # iterate targets list to build binary environment files
    for target_env in env_files :
        # get only filename without path and extension
        target_filename = os.path.splitext(os.path.basename(target_env))[0]
        if target_filename not in env_uboot_config:
            continue
        # build output file path with ext
        target_bin = os.path.join(env_bin_dir,
            target_filename + '.bin')
        # generated mkenvimage tool command line
        cmd_mkimg ='cat %s | grep -v -E "^$|^\#" |' \
                ' ./tools/mkenvimage -s %s -r -o %s -' \
                % ( target_env,
                d.getVar("ENV_SIZE",True), target_bin)
        print 'Building binary for %s target:' % (target_filename)
        print '%s' % cmd_mkimg
        # execute shell command
        ret = subprocess.call(cmd_mkimg, shell=True)
        if ret: return ret
    return 0
}

do_deploy_append() {
    install -d ${DEPLOYDIR}
    # deploy  binary U-boot environments
    echo "Deploying U-boot Environments binary files in ${DEPLOYDIR}/${ENV_DEPLOY_DIR}"
    install -d ${DEPLOYDIR}/${ENV_DEPLOY_DIR}
    
    
    cp ${ENV_BIN_DIR}/*.bin ${DEPLOYDIR}/${ENV_DEPLOY_DIR}
}

addtask build_mkimage_tool after do_compile before do_environment_mkimage
addtask environment_mkimage after do_build_mkimage_tool before do_deploy
