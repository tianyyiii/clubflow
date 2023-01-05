from flask import Flask,request
import os
app=Flask(__name__)
@app.route("/")
def hello_world():
    return "hello"
@app.route("/text_to_image")
def get_image():
    text=request.args.get("text")
    os.environ["REPLICATE_API_TOKEN"]="02fecee38e4b94eec80492c9d6636ef278d25f2f"
    import replicate
    model = replicate.models.get("stability-ai/stable-diffusion")
    version = model.versions.get("f178fa7a1ae43a9a9af01b833b9d2ecf97b1bcb0acfd2dc5dd04895e042863f1")
    output = version.predict(prompt=text)
    import stat
    import urllib.request

    img_url=output[0]
    print(img_url)
    file_path="C:\project_web\clubflow\workspace\img"
    file_name =text

    try:
        #是否有这个路径
        if not os.path.exists(file_path):
        #创建路径
            os.makedirs(file_path)
            #获得图片后缀
        file_suffix = os.path.splitext(img_url)[1]
        print(file_suffix)
            #拼接图片名（包含路径）
        filename = '{}{}{}{}'.format(file_path,os.sep,file_name,file_suffix)
        print(filename)
           #下载图片，并保存到文件夹中
        urllib.request.urlretrieve(img_url,filename=filename)

    except IOError as e:
        print("IOError")
    except Exception as e:
        print("Exception")
    return filename