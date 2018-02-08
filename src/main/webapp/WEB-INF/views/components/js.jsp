<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<script>
    function checkErrors(){
        alert( "event triggered" );
        var emailErrors = document.getElementById("email.errors");
        if(emailErrors != null){
            emailErrors.classList.add("alert alert-danger");
        }
        
        var passwordErrors = document.getElementById("password.errors");
        passwordErrors.addEventListener()
        if(passwordErrors !=null){
             passwordErrors.classList.add("alert alert-danger");
        }
    }
    

    $(window).unload(function() {
      alert('Handler for .unload() called.');
});
    
        /*
    var myButton = document.getElementById("bttn");
    myButton.addEventListener('click', function(){
        checkErrors();
    }) ;
    */
    
/*
   $("body").on('DOMSubtreeModified', ".myErrors", function() {
       alert( "event triggered" );
       var emailErrors = document.getElementById("email.errors");
        if(emailErrors != null){
            emailErrors.classList.add("alert alert-danger");
        }
        
        var passwordErrors = document.getElementById("password.errors");
        passwordErrors.addEventListener()
        if(passwordErrors !=null){
             passwordErrors.classList.add("alert alert-danger");
        }
    // code here
   });
   */
    
    
</script>