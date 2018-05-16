<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com    @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <!-- 
    	The codes are free, but we require linking to our web site.
    	Why to Link?
    	A true story: one girl didn't set a link and had no decent date for two years, and another guy set a link and got a top ranking in Google! 
    	Where to Put the Link?
    	home, about, credits... or in a good page that you want
    	THANK YOU MY FRIEND!
    -->
    <title>Green chat room - Bootdey.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  

</head>
<body>

<div class="container">
<div class="row">
        <div class="col-sm-12">
            <div class="panel panel-white border-top-green">
                <div class="panel-body chat"> 
                    <div class="row chat-wrapper">  
                        <div class="col-md-4">
                            <div class="compose-area"> 
                                <a href="javascript:void(0);" class="btn btn-default"><i class="fa fa-edit"></i> New Chat</a>
                            </div>
                            
                            <div>
                                <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 550px;">
                                <div class="chat-list-wrapper" style="overflow-y: auto; width: auto; height: 550px;">
                                    <ul class="chat-list">
                                        <li class="new">
                                            <span class="avatar available">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Gavin Free</span>
                                                    <small class="timestamp text-muted">
                                                        <i class="fa fa-clock-o"></i>1 secs ago
                                                    </small>
                                                </div>
                                                <p>
                                                   Hey, have you finished up with the Ladybug project?
                                                </p>
                                            </div>
                                        </li>  
                                        <li class="active">
                                            <span class="avatar available">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Yanique Robinson</span>
                                                    <small class="timestamp">
                                                        <i class="fa fa-clock-o"></i>3 secs ago
                                                    </small>
                                                </div>
                                                <p>
                                                    Cool. I'll see you guys then.
                                                </p>
                                            </div>
                                        </li>  
                                        <li>
                                            <span class="avatar offline">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Ryan Haywood</span>
                                                    <small class="timestamp text-muted">
                                                        <i class="fa fa-clock-o"></i>12 mins ago
                                                    </small>
                                                </div>
                                                <p>
                                                    Kevin, tomorrow is GoT night at my house. Bring your HDMI extension. Thanks.
                                                </p>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="avatar busy">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Geoff Ramsey</span>
                                                    <small class="timestamp text-muted">
                                                        <i class="fa fa-clock-o"></i>1 hour ago
                                                    </small>
                                                </div>
                                                <p>
                                                    Sales want to see you. Something about the new product.
                                                </p>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="avatar offline">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Kara Mendly</span>
                                                    <small class="timestamp text-muted">
                                                        <i class="fa fa-clock-o"></i>5 hours ago
                                                    </small>
                                                </div>
                                                <p>
                                                    Meeting next week Tuesday. Nothing serious, just bring teams work progress with you.
                                                </p>
                                            </div>
                                        </li> 
                                        <li>
                                            <span class="avatar busy">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">
                                                <div class="sns_header">
                                                    <span class="username">Jack Patillo</span>
                                                    <small class="timestamp text-muted">
                                                        <i class="fa fa-clock-o"></i>12 mins ago
                                                    </small>
                                                </div>
                                                <p>
                                                    hey, what does this error mean?
                                                </p>
                                            </div>
                                        </li>  
                                    </ul>
                                </div><div class="slimScrollBar" style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 478.639px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>
                            </div>
                            
                        </div>
                        
                        <div class="col-md-8">

                            <div class="recipient-box"> 
                                <select data-placeholder=" " class="form-control chzn-select chzn-done" multiple="" style="display: none;"> 
                                    <option value="k.mckoy@ztapps.com">Kevin Mckoy</option>
                                    <option value="y.robinson@ztapps.com" selected="">Yanique Robinson</option>
                                    <option value="gavino@ztapps.com">Gavino Free</option> 
                                    <option value="ggeoff@ztapps.com">Geoff Ramsey</option>
                                    <option value="kkara@ztapps.com">Kara Kingsley</option>
                                    <option value="barbs@ztapps.com">Barbara Dundkleman</option> 
                                </select>
                            </div>
                            
                            <div>

                                <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 452px;">
                                <div class="message-list-wrapper" style="overflow: hidden; width: auto; height: 452px;">
                                    <ul class="message-list">
                                        <li class="text-center">
                                            <a href="javascript:void(0);" class="btn btn-default">Load More Messages</a>
                                        </li>
                                        <li class="left">
                                            <span class="username">Yanique Robinson</span>
                                            <small class="timestamp">
                                                <i class="fa fa-clock-o"></i>9 mins ago
                                            </small> 
                                            <span class="avatar available tooltips" data-toggle="tooltip " data-placement="right" data-original-title="Yanique Robinson">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">   
                                                <div class="message well well-sm">
                                                    Hey, are you busy at the moment?
                                                </div>
                                            </div>
                                        </li>  
                                        <li class="right">
                                            <span class="username">Kevin Mckoy</span>
                                            <small class="timestamp">
                                                <i class="fa fa-clock-o"></i>5 mins ago
                                            </small> 
                                            <span class="avatar offline tooltips" data-toggle="tooltip " data-placement="left" data-original-title="Kevin Mckoy">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">   
                                                <div class="message well well-sm">
                                                    Um, no actually. I've just wrapped up my last project for the day.
                                                </div>
                                                <div class="clearfix"></div>
                                                <div class="message well well-sm">
                                                    Whats up?
                                                </div>
                                            </div>
                                        </li>  
                                        <li class="left">
                                            <span class="username">Yanique Robinson</span>
                                            <small class="timestamp">
                                                <i class="fa fa-clock-o"></i>3 mins ago
                                            </small> 
                                            <span class="avatar available tooltips" data-toggle="tooltip " data-placement="right" data-original-title="Yanique Robinson">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">   
                                                <div class="message well well-sm">
                                                    Well, I wanted to find out if you have any plans for tonight.
                                                </div>   
                                                <div class="clearfix"></div>
                                                <div class="message well well-sm">
                                                    <p><a href="#" class="white">Barbara</a> and I are going to this restaurant out of town.</p>
                                                    <img src="resources/sns/images/nobody.jpg" alt="">
                                                </div>
                                            </div>
                                        </li>  
                                        <li class="right">
                                            <span class="username">Kevin Mckoy</span>
                                            <small class="timestamp">
                                                <i class="fa fa-clock-o"></i>2 mins ago
                                            </small> 
                                            <span class="avatar tooltips" data-toggle="tooltip " data-placement="left" data-original-title="Kevin Mckoy">
                                                <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                            </span>
                                            <div class="body">   
                                                <div class="message well well-sm">
                                                    Wow that sounds great.
                                                </div>
                                            </div>
                                            </li> 
                                        <li class="left">
                                            <span class="username">Yanique Robinson</span>
                                                <small class="timestamp">
                                                    <i class="fa fa-clock-o"></i>56 secs ago
                                                </small> 
                                            <span class="avatar available tooltips" data-toggle="tooltip " data-placement="right" data-original-title="Yanique Robinson">
                                                    <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                                </span>
                                                <div class="body">   
                                                    <div class="message well well-sm">
                                                        Ok! We'll swing by your office at 5.
                                                    </div>
                                                </div>
                                            </li>  
                                        <li class="right">
                                            <span class="username">Kevin Mckoy</span>
                                                <small class="timestamp">
                                                    <i class="fa fa-clock-o"></i>3 secs ago
                                                </small> 
                                                <span class="avatar tooltips" data-toggle="tooltip " data-placement="left" data-original-title="Kevin Mckoy">
                                                    <img src="resources/sns/images/nobody.jpg" alt="avatar" class="img-circle">
                                                </span>
                                                <div class="body">   
                                                    <div class="message well well-sm">
                                                        Cool. I'l see you guys then.
                                                    </div>
                                                </div>
                                            </li>   
                                    </ul>
                                </div><div class="slimScrollBar" style="width: 7px; position: absolute; top: 265px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 187.092px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>

                                <div class="compose-box">
                                    <div class="row">
                                       <div class="col-xs-12 mg-btm-10">
                                           <textarea id="btn-input" class="form-control input-sm" placeholder="Type your message here..."></textarea>
                                        </div>
                                        <div class="col-xs-8">
                                            <button class="btn btn-green btn-sm">
                                                <i class="fa fa-camera"></i>
                                            </button>
                                            <button class="btn btn-green btn-sm">
                                                <i class="fa fa-video-camera"></i>
                                            </button>
                                            <button class="btn btn-green btn-sm">
                                                <i class="fa fa-file"></i>
                                            </button>
                                        </div>
                                        <div class="col-xs-4"> 
                                            <button class="btn btn-green btn-sm pull-right">
                                                <i class="fa fa-location-arrow"></i> Send
                                            </button>
                                        </div> 
                                    </div> 
                                </div>
                                
                            </div>
                            
                        </div>                                    
                    </div> 
                    
                </div> 
            </div>
        </div>

    </div>
</div>

<script type="text/javascript">
	$(function(){
    $(".chat-list-wrapper, .message-list-wrapper").niceScroll();
})
</script>
</body>
</html>