from flask import Flask,request
import os
import uuid

app=Flask(__name__)
@app.route("/")
def hello_world():
    return "hello"
@app.route("/text_to_image")
def get_image():
    text=request.args.get("text")
    # os.environ["REPLICATE_API_TOKEN"]="02fecee38e4b94eec80492c9d6636ef278d25f2f"
    os.environ["REPLICATE_API_TOKEN"]="a13f8f44cff2f6aa26ab398d0a8173eb429708ab"
    import replicate
    model = replicate.models.get("stability-ai/stable-diffusion")
    version = model.versions.get("f178fa7a1ae43a9a9af01b833b9d2ecf97b1bcb0acfd2dc5dd04895e042863f1")
    output = version.predict(prompt=text)
    import stat
    import urllib.request

    img_url=output[0]
    # img_url="https://replicate.delivery/pbxt/7QDUhKSrhPZyKZBDIaF2X0JvvtxYoLxq7Gdxb3bX5wd1n4EE/out-0.png"
    print(img_url)
    file_path="C:/project_web/clubflow/workspace/img"
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
        uuid_str = uuid.uuid4().hex
        tmp_file_name = 'tmp_%s' % uuid_str
        filename = '{}/{}{}'.format(file_path,tmp_file_name,file_suffix)
        print(filename)
           #下载图片，并保存到文件夹中
        urllib.request.urlretrieve(img_url,filename=filename)

    except IOError as e:
        print("IOError",e)
    except Exception as e:
        print("Exception")
    return filename.split("/")[-1]
@app.route("/text_to_vector")
def get_embedding():
    from sqlalchemy import update,bindparam
    import numpy as np
    text=request.args.get("text")
    postid=request.args.get("postid")
    print(text)
    postid=int(postid)
    from sentence_transformers import SentenceTransformer
    sentences =[text]

    model = SentenceTransformer('sentence-transformers/paraphrase-multilingual-MiniLM-L12-v2')
    embeddings = model.encode(sentences)[0]

    try:
        file=np.load("C:/project_web/clubflow/workspace/vector/embedding.npz")
        embedding_now=file["embedding"]
        post_now=file["post"]
        embedding_now=np.vstack((embedding_now,embeddings))
        post_now=np.hstack((post_now,postid))
        print(post_now)
        print(embedding_now.shape)
        print("yes_save")
        np.savez("C:/project_web/clubflow/workspace/vector/embedding.npz",embedding=embedding_now,post=post_now)

    except:
        np.savez("C:/project_web/clubflow/workspace/vector/embedding.npz",embedding=embeddings.reshape(1,-1),post=[postid])
    return "yes"
@app.route("/similar_post")
def get_similar_post():
    import numpy as np
    postid=request.args.get("postid")
    postid=int(postid)
    from sklearn.neighbors import NearestNeighbors
    x=np.load("C:/project_web/clubflow/workspace/vector/embedding.npz")["embedding"]
    y=np.load("C:/project_web/clubflow/workspace/vector/embedding.npz")["post"]
    index=np.where(y==postid)
    nbrs=NearestNeighbors(n_neighbors=5,algorithm="ball_tree").fit(x)
    distances,indices=nbrs.kneighbors(x[index].reshape(1,-1))
    near_post=[]
    for _ in indices[0]:
        near_post.append(y[_])
    near_post=near_post[1:]
    string=""
    for _ in near_post:
        string=string+str(_)+","
    print(string)
    return string


def random_file_name(path):
    # path = f"C:/Users/xxxx/xxxx/xxx视频"
    list_name = os.listdir(path)    # 遍历目录名

    for k in list_name:
        name1 = "".join(random.sample([x for x in string.ascii_letters + string.digits] , 8))     # 随机生成8位字母+数字
        name2 = random.randint(1, 50)
        old_name = os.path.join(path, k)     # 旧文件目录名
        new_name = os.path.join(path, str(name2) + '.mp4')       # 新文件目录名
        if os.path.exists(new_name):     # 判断是否存在该文件，存在则输出目录名，并用name1命名
            print(new_name)
            os.rename(old_name, os.path.join(path, str(name1) + '.mp4'))
        else:
            os.rename(old_name, new_name)     # 不存在该文件，则重命名 os.rename(src要修改的目录名, dst修改后的目录名)

