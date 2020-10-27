var type=0;

function DragImgUpload(id,options) {
    this.me = $(id);
    var defaultOpt = {
        boxWidth:'270px',
        boxHeight:'auto'
    }
    this.preview = $('<div id="preview" style="border: 2px dashed #e6e6e6; margin: 5px 5px 5px 5px; height: 100%; overflow: hidden;"><img src="../lib/images/upload.png" class="img-responsive" id="imgPic"  style="width: 100%;height: auto;" alt="" title=""> <h4 style="text-align: center;color: #e6e6e6;" id="itxt">支持拖拽或選擇圖片</h4></div>');
    this.opts=$.extend(true, defaultOpt,{
    }, options);
    this.init();
    this.callback = this.opts.callback;
}

//定义原型方法
DragImgUpload.prototype = {
    init:function () {
        this.me.append(this.preview);
        this.me.append(this.fileupload);
        this.cssInit();
        this.eventClickInit();
    },
    cssInit:function () {
        this.me.css({
            'width':this.opts.boxWidth,
            'height':this.opts.boxHeight,
            'border':'1px solid #cccccc',
            'padding':'10px',
            'cursor':'pointer'
        })
        this.preview.css({
            'height':'100%',
            'overflow':'hidden'
        })

    },
    onDragover:function (e) {
        e.stopPropagation();
        e.preventDefault();
        e.dataTransfer.dropEffect = 'copy';
    },
    onDrop:function (e) {
        $("#itxt").hide();
        var self = this;
        e.stopPropagation();
        e.preventDefault();
        var fileList = e.dataTransfer.files; //获取文件对象
        // do something upload
        if(fileList.length == 0){
            return false;
        }
        //检测文件是不是图片
        if(fileList[0].type.indexOf('image') === -1){
            layer.msg("您拖的不是图片！", {icon: 2, time: 1200});
            return false;
        }

        //拖拉图片到浏览器，可以实现预览功能
        var img = window.URL.createObjectURL(fileList[0]);
        var filename = fileList[0].name; //图片名称
        var filesize = Math.floor((fileList[0].size)/1024/1024);
        if(filesize>5){
            layer.msg("上传大小不能超过5M！", {icon: 2, time: 1200});
            return false;
        }
        //console.log("asasas")
        //$("#maskBar").attr("style","block");
        self.me.find("img").attr("src",img);
        self.me.find("img").attr("title",filename);
        $(".maskBar").show();
        if(this.callback){
            this.callback(fileList);
        }

    },
    eventClickInit:function () {
        var self = this;
        this.me.unbind().click(function () {
            self.createImageUploadDialog();
        })
        var dp = this.me[0];
        dp.addEventListener('dragover', function(e) {
            self.onDragover(e);
        });
        dp.addEventListener("drop", function(e) {
            self.onDrop(e);
        });


    },
    onChangeUploadFile:function () {
        if(type==1){
            return false;
        }
        $("#itxt").hide();
        var fileInput = this.fileInput;
        var files = fileInput.files;
        var file = files[0];
        if(file.type.indexOf('image') === -1){
            layer.msg("只能選擇圖片！", {icon: 2, time: 1200});
            return false;
        }
        //console.log("asasas1212")
        //$("#maskBar").attr("style","block");
        var img = window.URL.createObjectURL(file);
        var filename = file.name;
        var filesize = Math.floor((file.size)/1024/1024);
        if(filesize>5){
            layer.msg("上传大小不能超过5M！", {icon: 2, time: 1200});
            return false;
        }
        this.me.find("img").attr("src",img);
        this.me.find("img").attr("title",filename);
        $(".maskBar").show();
        if(this.callback){
            this.callback(files);
        }

    },
    createImageUploadDialog:function () {
        var fileInput = this.fileInput;

        //if (!fileInput) {
            //创建临时input元素
            fileInput = document.createElement('input');
            //设置input type为文件类型
            fileInput.type = 'file';
            //设置文件name
            fileInput.name = 'images';
            fileInput.id = 'images';
            fileInput.hidden= 'hidden';
            //允许上传多个文件
            fileInput.multiple = false;
            fileInput.onchange  = this.onChangeUploadFile.bind(this);
            this.fileInput = fileInput;
       // }
        //触发点击input点击事件，弹出选择文件对话框
        //Pause(this,100);
       // var b=0;
        if (type!=1) {
            fileInput.click();
        }
    }
}

