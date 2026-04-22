# [Silver IV] Крестики-нолики - 29101 

[문제 링크](https://www.acmicpc.net/problem/29101) 

### 성능 요약

메모리: 21576 KB, 시간: 296 ms

### 분류

구현, 그래프 이론, 문자열, 그래프 탐색, 너비 우선 탐색

### 제출 일자

2026년 4월 22일 21:35:31

### 문제 설명

<p>Однажды, прогуливаясь по Королевской Гавани, лорд Петир Бейлиш нашел листок бумаги в клетку, исписанный странными символами. Оказалось, что кто-то играл на этом листке в крестики-нолики.</p>

<p>Лорд Бейлиш прекрасно знает правила этой игры. Игроки ходят по очереди, один из них ставит в любую свободную клетку поля крестик, второй --- нолик. Петир Бейлиш не знает, кто играл эту партию в крестики-нолики, но ему очень хочется узнать, доиграна она или нет. Партия считается доигранной, если существует горизонтальная, вертикальная или диагональная линия из пяти крестиков или ноликов. Позиция может быть неккоректной, Петира это не волнует.</p>

<p>Лорд Бейлиш считает вас достойной кандидатурой, чтобы помочь ему. Ваша задача --- написать программу, которая сможет определить, доиграна партия или нет.</p>

### 입력 

 <p>В самой первой строке входного файла заданы числа <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> и <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45A TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>m</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$m$</span></mjx-container> (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D45A TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>n</mi><mo>,</mo><mi>m</mi><mo>≤</mo><mn>1000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le n, m \le 1000$</span></mjx-container>) --- размеры игрового поля.</p>

<p>В следующих <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> строках записано по <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45A TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>m</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$m$</span></mjx-container> символов <<X>>, <<O>> или <<.>>, которые означают, что в данной клетке стоит крестик, нолик, либо она пуста, соответственно. Обращаем ваше внимание, что <<X>> и <<O>> --- заглавные буквы латинского алфавита. </p>

### 출력 

 <p>В единственной строке выходного файла выведите <code>Yes</code>, если игра доиграна, и <code>No</code>, если нет.</p>

