const fileData = document.getElementById("inpfile");
const submit = document.getElementById("btn");

const contents = document.getElementById("contents");

const videoarea = document.getElementById('video');




const uploadFile = async () => {
  const formData = new FormData();

  const fileD = fileData.files[0];

  formData.append("file", fileD);
  // const header = new Headers();
  // header.append('Access-Control-Allow-Origin', 'http://localhost:8080/api/v1/upload');
  // header.append('POST');

  const res = await fetch("http://localhost:8080/api/v1/upload", {
    method: "POST",
    body: formData,
  });
  const result = await res.json();
  console.log(result);
};

submit.addEventListener("click", uploadFile);

const createEle = () => {
  const ele = document.createElement("div");
  Object.assign(ele.style, {
    display: "flex",
    height: "15vh",
    width: "25vw",
    margin:'auto',
    marginTop:'2vh',
    padding:'1vh',
    backgroundColor:'black'
  });



  const image = document.createElement("img");
  image.src = "./thumbnail.jpg";
  //   image.style.width='100px';
  image.style.height = "15vh";
  image.alt = "thumbnail";
  ele.appendChild(image);  

  return ele;
};

const onClickHandle = (eve)=>{

    const uri =`http://localhost:9090/${eve}`
    
    const videoEle = document.createElement('video');


    videoEle.autoplay=true;
    videoEle.loop =true;
    videoEle.controls =true;

    Object.assign(videoEle.style,{
        height:'100%',
        width:'100%'
    })
    videoEle.preload='none';

    videoEle.src=uri;

    videoarea.innerHTML ='';
    videoarea.appendChild(videoEle);
    
}

const allParse = (prop) => {
  prop.map( async (cc) => {
    const ele = createEle();
    ele.style.cursor='pointer';
    const title = document.createElement('p');
    title.innerHTML= cc.fileName;
    title.style.color ='white';
    Object.assign(title.style,{
        padding:'1vw 1vh',

    })
    ele.appendChild(title);
    ele.id=`api/v1/watch=${cc.fileName}`
    ele.addEventListener('click',()=>onClickHandle(`api/v1/watch=${cc.fileName}`));
    contents.appendChild(ele);
  });
};

const videoLoad = async () => {
  const res = await fetch("http://localhost:8080/api/v1/getallvideo", {
    method: "GET",
  });

  const alldata = await res.json();
  contents.innerHTML='';
  allParse(alldata);
}

videoLoad();

setInterval(videoLoad,5000);