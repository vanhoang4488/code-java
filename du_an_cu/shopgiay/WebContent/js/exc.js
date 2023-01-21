var arr = document.getElementsByClassName('quantity_product');
var i = 0;
while(i < arr.length){
	function setInputFilter(textbox, inputFilter) {
        ["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
           textbox.addEventListener(event, function() {
             if (inputFilter(this.value)) {
               this.oldValue = this.value;
               this.oldSelectionStart = this.selectionStart;
               this.oldSelectionEnd = this.selectionEnd;
              } else if (this.hasOwnProperty("oldValue")) {
               this.value = this.oldValue;
               this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
              } else {
               this.value = "";
               }
         });
      });
    }

   setInputFilter(arr[i], function(value) {
          return /^\d*\.?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
   });
   
   var btn = document.getElementsByClassName('decrease')[i];
   arr[i].onchange = function(){
	   if(this.value <=1 ){
	      btn.disabled = "disabled";
	   }
   }
   i++;
};