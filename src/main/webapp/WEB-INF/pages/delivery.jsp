<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Сезонні дрібнички | Повітряні кульки, свічки, новорічні прикраси доставка по Луцьку та всій Україні</title>
      <link rel="stylesheet" href="/resources/css/style.css">

  
</head>
<body>
  <section class="intro" id="intro">
    <section class="balloons-conatiner" id="balloons-container">
        <div class="balloon yellow" ></div>
        <div class="balloon blue"   ></div>
        <div class="balloon purple" ></div>
        <div class="balloon red"    ></div>
        <div class="balloon cyan"   ></div>
        <!-- infinite-->
        <div class="balloon pink"   ></div>
        <div class="balloon orange" ></div>
        <div class="balloon blue"   ></div>
        <div class="balloon yellow" ></div>
        <div class="balloon purple" ></div>
        <div class="balloon green"  ></div>             
        <div class="balloon cyan"   ></div>
        <div class="balloon red"    ></div>
      </section>
        
    
<div class="menu-section">
  <div class="menu-toggle">
    <div class="one"></div>
    <div class="two"></div>
    <div class="three"></div>
  </div>
  <nav>
		<ul role="navigation" class="hidden">
			<li><a href="/index">Про нас</a></li>
			<li><a href="/shop">Каталог</a></li>
			<li><a href="/delivery">Доставка</a></li>
			<li><a href="#">Контакти</a></li>
		</ul>
	</nav>
</div>
<div id="photo-produckt_list_boom_text_about_balloon"><img src="/resources/photo/boom.png" alt="сезонні дрібнички | Повітряні кульки| Доставка по всій Україні " width="210px"> </div>
 <div id="photo-produckt_list"><img src="/resources/photo/balloons1.png" alt="сезонні дрібнички| Повітряні кульки | Доставка по всій Україні " width="250px"> </div>

 
    <!--      ---------------------------------------------HOME PAGE----------------------------------------------------------->
    <div id="background_for_delivery">
  <article id="one_dev" data-color="#10e88a"><h1>Доставка</h1><p>
  
    
    ✓Нова Пошта<br>
Доставка на протязі 2 робочих днів після підтвердження замовлення на склад перевізника в місті одержувача. <br>
✓Кур'єром по Луцьку<br>
Доставка по Луцьку протягом 2 робочих днів після підтвердження замовлення, пн - пт з 10.00 до 19.00. Замовлення понад 2000 грн доставляються безкоштовно.<br>
✓Інші транспортні служби<br>
Інтайм, Делівері. Відправка протягом 2 днів після передоплати. Доставка оплачується за тарифами перевізників.<br>
✓Самовивіз<br>
Самовивіз здійснюється зі складу у місті Луцьк.<br> 
</p> <div class="clear">
   
    
</div></article>
</div>
 <div id="photo-produckt_list_2"><img src="/resources/photo/baloon2.png" alt="сезонні дрібничка" width="250px"> </div>

 <!--      ---------------------------------------------BALLOON----------------------------------------------------------->

<div id="firework">
    
          
          <div class="before"></div>
              <div class="after"></div>
   
<article id="two_dev" data-color="#7f3995">
<h1>ОПЛАТА</h1><p id="dev_text">✓Готівкою при отриманні<br>
✓Оплата готівкою кур'єру або при самовивозі.<br>
✓Накладений платіж<br>
✓Післяплата при отриманні на складі нової пошти. Окремо сплачується комісія відповідно до тарифів перевізника.<br>
✓Оплата на картку<br>
✓Оплата на банківську карту через касу, термінал або онлайн-банкінг.<br>
</p> <div class="clear">
</div> 

</article>
  


    
     <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='/resources/js/e947f15a449125c42930da18a.js'></script>
  </div>
  
   </section>
  
  
  
  
  

   
   <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="/resources/js/index.js"></script>
    <script  src="/resources/js/index2.js"></script>
    <script  src="/resources/js/index3.js"></script>
    
    <script>/* Demo intro for www.eightyears.co.uk
looks better on site with icon-font ballons
*/

//Intro Balloon Pops - colour changes
var balloonsContainer = document.getElementById("balloons-container"),
    balloons = balloonsContainer.childNodes,
    introTitle = document.getElementById('intro-title'),
    introSub = document.getElementById('intro-sub'),
    introBut = document.getElementById('intro-button');

for (var i = 0; i < balloons.length; i++) {
    var balloon = balloons[i];
    balloon.addEventListener('click', pop, false);
}     

function pop(e) {
    var element = e.target;
    if (element.classList.contains('yellow')) {
        intro.style.background = 'rgb(235,255,20)';
        intro.style.header.background = 'rgb(235,255,20)';
        
        introBut.className = "button-yellow";
        if (introTitle.style.color !== 'rgb(51,51,51)') {
             introTitle.style.color = 'rgb(51,51,51)';
             introSub.style.color   = 'rgba(51,51,51,.8)';
            
        }
    }
    else if (element.classList.contains('blue')) {
        intro.style.background = 'rgb(39,20,255)';
        introBut.className = "button-blue";
        if (introTitle.style.color !== 'rgb(255,255,255)') {
            introTitle.style.color = 'rgb(255,255,255)';
            introSub.style.color   = 'rgba(255,255,255,.8)';
        }
    }
     else if (element.classList.contains('purple')) {
         intro.style.background = 'rgb(189,96,255)';
         introBut.className = "button-purple";
         if (introTitle.style.color !== 'rgb(255,255,255)') {
             introTitle.style.color = 'rgb(255,255,255)';
             introSub.style.color   = 'rgba(255,255,255,.8)';
         }
    }
      else if (element.classList.contains('red')) {
          intro.style.background = 'rgb(255,39,20)';
          introBut.className = "button-red";
          if (introTitle.style.color !== 'rgb(255,255,255)') {
              introTitle.style.color = 'rgb(255,255,255)';
              introSub.style.color   = 'rgba(255,255,255,.8)';
         }    
    }
      else if (element.classList.contains('cyan')) {
          intro.style.background = 'rgb(20,235,255)';
          introBut.className = "button-cyan";
          if (introTitle.style.color !== 'rgb(255,255,255)') {
              introTitle.style.color = 'rgb(255,255,255)';
              introSub.style.color   = 'rgba(255,255,255,.8)';
         }
    }
      else if (element.classList.contains('pink')) {
          intro.style.background = 'rgb(255,138,187)';
          introBut.className = "button-pink";
          if (introTitle.style.color !== 'rgb(255,255,255)') {
              introTitle.style.color = 'rgb(255,255,255)';
              introSub.style.color   = 'rgba(255,255,255,.8)';
          }
    }
      else if (element.classList.contains('green')) {
          intro.style.background = 'rgb(20,189,34)';
          introBut.className = "button-green";
          if (introTitle.style.color !== 'rgb(255,255,255)') {
              introTitle.style.color = 'rgb(255,255,255)';
              introSub.style.color   = 'rgba(255,255,255,.8)';
         }
    }
      else if (element.classList.contains('orange')) {
          intro.style.background = 'rgb(255,171,53)';
          introBut.className = "button-orange";
          if (introTitle.style.color !== 'rgb(255,255,255)') {
              introTitle.style.color = 'rgb(255,255,255)';
              introSub.style.color   = 'rgba(255,255,255,.8)';
          }
    }   
    element.style.display = "none";
    e.preventDefault();
    e.stopPropagation();
};
    
    </script>
  

  
</body>

</html>
