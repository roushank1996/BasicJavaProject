<!DOCTYPE html>
<html lang="en">
<head>
    <style>
    *{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
}
main
{
 
  height: 120vh;
  background: url(12.jpg) fixed no-repeat;
  background-size: cover;
}
#container{
  width: 350px;
  height: 500px;
  background: inherit;
  position: absolute;
  overflow: hidden;
  top: 50%;
  left: 50%;
  margin-left: -175px;
  margin-top: -250px;
  border-radius: 8px;
}
#container:before{
  width: 400px;
  height: 550px;
  content: "";
  position: absolute;
  top: -25px;
  left: -25px;
  bottom: 0;
  right: 0;
  background: inherit;
  box-shadow: inset 0 0 0 200px rgba(255,255,255,0.2);
  filter: blur(10px);
}
form img{
  width: 120px;
  height: 120px;
  border-radius: 50%;
}
form{
  text-align: center;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}
input{
  background: 0;
  width: 200px;
  outline: 0;
  border: 0;
  border-bottom: 2px solid rgba(255,255,255, 0.3);
  margin: 11px 0;
  padding-bottom: 10px;
  font-size: 15px;
  font-weight: bold;
  color: rgba(255,255,255, 0.8);
}
input[type="submit"]{
  border: 0;
  border-radius: 7px;
  padding-bottom: 0;
  height: 30px;
  background: #df2359;
  color: white;
  cursor: pointer;
  transition: all 600ms ease-in-out;
}
input[type="submit"]:hover{
  background: #C0392B;
}
span a{
  color: rgba(255,255,255, 0.8);
}
h3{
	color: white;
	text-align: center;
	text-decoration: underline;
}
    
    </style>
</head>
<body >
    
        <main><h3>Register</h3>
                <div id="container">
                  <form action="DemoServlet" method="post">
                      
                    
                    Name: <input type="text" name="name" required><br>
                    Email: <input type="email" name="email" required><br>
                    Username:<input type="text" name="username" required><br>
                    Age:<input type="text" name="age" required><br>
                    Password:<input type="password" name="password" required><br>
                    <input type="file" name="image" required><br>
                    <input type="submit" value="SIGN UP"><br>
                    
                  </form>
                </div>
        </main>
    
</body>
</html>