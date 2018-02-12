<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<style>
    body{
        font-family: monospace
    }
    
    .myHeader{
        background-color: #333333;;
        text-align: center !important;
        padding: 20px 0px 20px 0px;
        margin-bottom: 50px;
    }

    .myHeader a{
        font-family: serif;
        text-decoration: none;
        color: white;
        text-transform: uppercase;
        font-size: 100%;
        font-weight: 700;    
    }
    /*
    .wrapper{
        margin-left: auto;
        margin-right: auto;
        max-width: 60%;
    }
    */
    
    .has-error{
        color: black;
        
    }
    
    .logInForm {
        margin-top: auto;
    }
    
    .footer {
       position: fixed;
       left: 0;
       bottom: 0;
       background-color: #333333;;
       color: white;
       text-align: center;
    }
    
    .footer a {
        text-decoration: none;
        color: white;
    }
    
    #email.errors{
        background-color: aqua;
        margin: 10px;
    }
</style>