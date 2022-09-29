<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
		footer {
		  /* footer를 aside위에 올리기 위해 사용(부유객체) */
		  position: absolute;
		  height: 60px;
		  width: 100%;
		  padding: 0 25px;
		  line-height: 60px;
		  color: #8a8c8f;
		  border-top: 1px solid #dee5e7;
		  background-color: #3c3935;
		}
		        
        footer img {
            width: 90px;
            height: 90px;
            border-radius: 50%;
            margin-top: 7px;
        }
        
        .foo_div {
            float: left;
        }
        
        .foo_div1 {
            text-align: center;
        }
        
        .foo_div1 span {
            font-size: 15px;
            color: white;
        }
        
        .foo_div1 p {
            margin-top: 5px;
            color: white;
        }
        
        .foo_div1 img {
            width: 25px;
            height: 25px;
            margin-top: 10px;
        }
</style>
<footer>
    <div class="foo_div">
    </div>
    <div class="foo_div1">
        <span>Daliy Note</span> <span>  |  </span>
        <span>Copyright ⓒ 2022 by yoosooyoung All Pictures cannot be copied without permission.</span>
        <p></p>
    </div>
</footer>
