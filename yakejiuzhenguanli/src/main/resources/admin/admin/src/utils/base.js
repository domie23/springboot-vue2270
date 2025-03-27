const base = {
    get() {
        return {
            url : "http://localhost:8080/yakejiuzhenguanli/",
            name: "yakejiuzhenguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yakejiuzhenguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "牙科就诊管理系统"
        } 
    }
}
export default base
