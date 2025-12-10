package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
 *   ---------------------------------------------
 *   				ThymeLeaf 		    Vue3
 *   ---------------------------------------------
 *   렌더링			서버 렌더링		클라이언트 렌더링
 *   검색엔진         매우 뛰어나다      => 서버 렌더링 사용 (Nuxt)
 *   데이터바인딩      단방향           양방향 => AngularJS / React
 *   속도			서버처리 중심      브라우저 중심
 *                  Back-End        Front-End
 *   사용처           관리페이지        | 모바일 => 동적
 *                  | 공공기업 사이트   | 페이징 / 검색 / 예약 / 결제
 *                                  | 채팅 / AI / GPT
 *   => 기본 : ThymeLeaf / JSP
 *   => 동적 : React / Vue
 *   
 *   1. DOM (ML => 저장이 될 때 트리형태로 저장)
 *                           ------- DOM (Document Object Model)
 *      Vue3 / React
 *       |       |
 *       ---------
 *           |
 *         가상 돔 + 반응형 => 동작
 *     = 가상 돔
 *       브라우저 화면을 직접 실행하는 실제 돔이 아니다
 *       가상메모리에 저장 => 변경시마다 실제 돔에 전송
 *             |                  |
 *             -------------------- diff (비교)
 *       속도를 빠르게 / 깜빡이는 효과 없이
 *     = 컴파일 = 렌더링 실시간 수행
 *       => 데이터만 변경
 *   
 *   2. MVVM (Model - View - ViewModel)
 *      MVC (Model - View - Controller)
 *      
 *       => 요청 = Controller = Model = Controller = View
 *                    |          |          |         |
 *                 요청 받기     요청 처리   결과값 전송  화면 출력
 *       => 요청 = Model <======> ViewModel <======> View
 *                  |                |                |
 *               데이터 관리		 데이터 변경          화면 출력
 *                               데이터 처리          mount 영역 => <template>
 *                  |                |    
 *                data()          created()
 *                                mounted()
 *                                updated()
 *                                unmounted()
 *                                methods:{}
 *       Model : 데이터의 상태 관리 (state)
 *               Pinia/VueX ==> 저장 (store)
 *       View : HTML 제어
 *       ViewModel : 양방향 바인딩, 반응성 관리, 이벤트 처리
 *       ** Model 이 변경되면 ViewModel ==> HTML 반영
 *          | 설정된 변수가 변경시 
 *    
 *    3. 생명 주기 함수
 *       created() : Vue 생성시 자동 호출
 *       mounted() : 브라우저에 HTML이 번역 후 출력이 된 경우
 *       updated() : 데이터값이 변경된 후
 *       unmounted() : 화면 변경
 *       => CallBack => Vue 시스템에 의해 자동 호출
 *       
 *       methods : 사용자 정의 함수 => 자동 x
 *       *** React / Vue / Next / Node / Nuxt => 기본 코딩은 JavaScript
 *    
 *    4. 디렉티브
 *       v-model : 입력시에 data()에 있는 변수에 값을 설정
 *          | 양방향 통신
 *          | react 에 없다 => onchange
 *       v-bind => 속성에 값 설정 => :
 *        <img v-bind:src="vo.poster">
 *        <img :src="vo.poster">
 *       v-on => 이벤트 처리
 *        <button v-on:click="함수">
 *               => v-on => @click=""
 *       v-for : 반복문 => for-each 만 지원
 *       v-pre : 있는 그대로 출력
 *       v-once : 한번만 수행
 *       v-slot : 컴포턴트에 데이터 전송 => prop:[]
 *    -------------------------------------------------------------------
 *    1. Component => CDN
 *         | => vuex / pinia
 *    기본 패턴
 *    <script>
 *      const app=Vue.createAPP({
 *      	data(){
 *      		return {
 *      
 *      		}
 *      	},
 *      	mounted(){
 *      		시작과 동시에 데이터 읽기
 *      	},
 *      	methods:{
 *      		사용자 정의
 *      	},
 *      	components:{
 *      
 *      	},
 *      	computed:{
 *      
 *      	}
 *      })
 *       
 */
@Controller
public class FoodController {
	@GetMapping("/food/find")
	public String food_find()
	{
		return "food/find"; // templates/food/find.html
	}
	
	@GetMapping("/food/detail")
	public String food_detail(@RequestParam("fno") int fno, Model model)
	{
		model.addAttribute("fno", fno);
		return "food/detail";
	}
}
