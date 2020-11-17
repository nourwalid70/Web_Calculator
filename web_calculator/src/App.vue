<template>

<div id="calc">
<div class="display">{{current || '0'}}</div>  
<button class="btn">&#37;</button>
<button class="btn">CE</button>
<button class="btn">C</button>
<button class="btn">DEL</button>
<button class="btn">&#8543;x</button>
<button class="btn">x&#178;</button>
<button class="btn">&#8730;x</button>
<button class="btn">&#247;</button>
<button @click="append('7')" class="btn">7</button>
<button @click="append('8')" class="btn">8</button>
<button @click="append('9')" class="btn">9</button>
<button class="btn">&times;</button>
<button @click="append('4')" class="btn">4</button>
<button @click="append('5')" class="btn">5</button>
<button @click="append('6')" class="btn">6</button>
<button class="btn">&minus;</button>
<button @click="append('1')" class="btn">1</button>
<button @click="append('2')" class="btn">2</button>
<button @click="append('2')" class="btn">3</button>
<button class="btn">&plus;</button>
<button class="btn">&#8314;/-</button>
<button @click="append('0')" class="btn">0</button>
<button class="btn">.</button>
<button class="btn">&equals;</button>
</div>
</template>

<script>
 export default{
   data(){
     return{
       current :'',
     }
   },
   methods:{
  append(number){
    this.current = `${this.current}${number}`;
     },
   }
 }

</script>

<style>

   #calc{
     display: grid;
     font-size: 50px ;
     width: 400px;
     height: 500px;
     grid-template-columns: repeat(4,1fr) ;
     grid-auto-rows: minmax(30px,auto);
     margin: 0 auto;
     background-color: rgb(80, 9, 62);
    }
 .display{
   text-align: right;
   grid-column: 1/5;
   background-color: rgb(80, 9, 62);
   color: silver;
   overflow: hidden;
 }
  .btn{
    border: 1px solid rgba(139, 42, 118, 0.452);
    font-size: 20px;
    color: rgb(80, 9, 62);
    background: rgb(241, 162, 241); 
    outline: none; 
    margin: 3px;
    font-weight: bold;
  } 
.btn:hover{
    color:rgb(241, 162, 241);
    background: rgb(80, 9, 62); 
}

</style>