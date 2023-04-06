


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .chat-bar-collapsible {
                position: fixed;
                bottom: 0;
                right: 50px;
                box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            }

            .collapsible {
                background-color: #5bc1ac;
                color: white;
                cursor: pointer;
                padding: 18px;
                width: 350px;
                text-align: left;
                outline: none;
                font-size: 18px;
                border-radius: 10px 10px 0px 0px;
                border: 3px solid white;
                border-bottom: none;
            }

            .content {
                max-height: 0;
                overflow: hidden;
                transition: max-height 0.2s ease-out;
                background-color: #f1f1f1;
            }

            .full-chat-block {
                width: 350px;
                background: white;
                text-align: center;
                overflow: auto;
                scrollbar-width: none;
                height: max-content;
                transition: max-height 0.2s ease-out;
            }

            .outer-container {
                min-height: 500px;
                bottom: 0%;
                position: relative;
            }

            .chat-container {
                max-height: 500px;
                width: 100%;
                position: absolute;
                bottom: 0;
                left: 0;
                scroll-behavior: smooth;
                hyphens: auto;
            }

            .chat-container::-webkit-scrollbar {
                display: none;
            }

            .chat-bar-input-block {
                display: flex;
                float: left;
                box-sizing: border-box;
                justify-content: space-between;
                width: 100%;
                align-items: center;
                background-color: rgb(235, 235, 235);
                border-radius: 10px 10px 0px 0px;
                padding: 10px 0px 10px 10px;
            }

            .chat-bar-icons {
                display: flex;
                justify-content: space-evenly;
                box-sizing: border-box;
                width: 25%;
                float: right;
                font-size: 20px;
            }

            #chat-icon:hover {
                opacity: .7;
            }

            /* Chat bubbles */

            #userInput {
                width: 75%;
            }

            .input-box {
                float: left;
                border: none;
                box-sizing: border-box;
                width: 100%;
                border-radius: 10px;
                padding: 10px;
                font-size: 16px;
                color: #000;
                background-color: white;
                outline: none
            }

            .userText {
                color: white;
                font-family: Helvetica;
                font-size: 16px;
                font-weight: normal;
                text-align: right;
                clear: both;
            }

            .userText span {
                line-height: 1.5em;
                display: inline-block;
                background: #5ca6fa;
                padding: 10px;
                border-radius: 8px;
                border-bottom-right-radius: 2px;
                max-width: 80%;
                margin-right: 10px;
                animation: floatup .5s forwards
            }

            .botText {
                color: #000;
                font-family: Helvetica;
                font-weight: normal;
                font-size: 16px;
                text-align: left;
            }

            .botText span {
                line-height: 1.5em;
                display: inline-block;
                background: #e0e0e0;
                padding: 10px;
                border-radius: 8px;
                border-bottom-left-radius: 2px;
                max-width: 80%;
                margin-left: 10px;
                animation: floatup .5s forwards
            }

            @keyframes floatup {
                from {
                    transform: translateY(14px);
                    opacity: .0;
                }
                to {
                    transform: translateY(0px);
                    opacity: 1;
                }
            }

            @media screen and (max-width:600px) {
                .full-chat-block {
                    width: 100%;
                    border-radius: 0px;
                }
                .chat-bar-collapsible {
                    position: fixed;
                    bottom: 0;
                    right: 0;
                    width: 100%;
                }
                .collapsible {
                    width: 100%;
                    border: 0px;
                    border-top: 3px solid white;
                    border-radius: 0px;
                }
            }
        </style>
    

    <body>
        <!-- CHAT BAR BLOCK -->
        <div class="chat-bar-collapsible">
            <button id="chat-button" type="button" class="collapsible">Chat with us!
                <i id="chat-icon" style="color: #fff;" class="fa fa-fw fa-comments-o"></i>
            </button>

            <div class="content">
                <div class="full-chat-block">
                    <!-- Message Container -->
                    <div class="outer-container">
                        <!-- User input name -->
                        <div class="chat-bar-input-block" id="name">
                            <div >
                                <input id="nameInput" class="input-box" type="text" name="msg"
                                       placeholder="Enter your name ...">
                                <p></p>
                            </div>

                            <div class="chat-bar-icons">
                                <i id="chat-icon" style="color: #333;" class="fa fa-fw fa-send"
                                   onclick="sendName()"></i>
                            </div>
                        </div>
                        <div class="chat-container">
                            <!-- Messages -->
                            <div id="chatbox">
                                <h5 id="chat-timestamp"></h5>
                                <p id="botStarterMessage" class="botText"><span>Loading...</span></p>
                            </div>

                            <!-- User input box -->
                            <div class="chat-bar-input-block" id="user">
                                <div id="userInput">
                                    <input id="textInput" class="input-box" type="text" name="msg"
                                           placeholder="Tap 'Enter' to send a message">
                                    <p></p>
                                </div>

                                <div class="chat-bar-icons">
                                    <i id="chat-icon" style="color: #333;" class="fa fa-fw fa-send"
                                       onclick="sendButton()"></i>
                                </div>
                            </div>


                            <div id="chat-bar-bottom">
                                <p></p>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
                                           document.getElementById("user").style.display = 'none';
                                           var coll = document.getElementsByClassName("collapsible");

                                           for (let i = 0; i < coll.length; i++) {
                                               coll[i].addEventListener("click", function () {
                                                   this.classList.toggle("active");

                                                   var content = this.nextElementSibling;

                                                   if (content.style.maxHeight) {
                                                       content.style.maxHeight = null;
                                                   } else {
                                                       content.style.maxHeight = content.scrollHeight + "px";
                                                   }

                                               });
                                           }
                                           var websocket = new WebSocket("ws://localhost:8909/mavenproject1/chatRoomServer");
                                           websocket.onopen = function (message) {
                                               processOpen(message);
                                           };
                                           websocket.onmessage = function (message) {
                                               processMessage(message);
                                           };
                                           websocket.onclose = function (message) {
                                               processClose(message);
                                           };
                                           websocket.onerror = function (message) {
                                               processError(message);
                                           };
                                           function processOpen(message) {
                                               document.getElementById("botStarterMessage").innerHTML = '<p class="botText"><span>' + "Please enter name " + '</span></p>';

                                               let time = getTime();

                                               $("#chat-timestamp").append(time);
                                               document.getElementById("userInput").scrollIntoView(false);


                                           }
                                           function processMessage(message) {
//                                               console.log(message);

                                               let userHtml = '<p class="userText"><span>' + message.data + '</span></p>';
                                               $("#textInput").val("");
                                               $("#chatbox").append(userHtml);
                                               document.getElementById("chat-bar-bottom").scrollIntoView(true);
                                           }
                                           function processClose(message) {
                                               textInput.value += "Server Disconnect... \n";
                                           }
                                           function processError(message) {
                                               textInput.value += "Error... " + message + " \n";
                                           }
                                           function sendButton() {
                                               if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
                                                   console.log("hello");


                                                   websocket.send(textInput.value);
                                                   textInput.value = "";
                                               }
                                           }
                                           function sendName() {
                                               const adminChat =[
                                                   ""
                                               ]
                                               document.getElementById("name").style.display = 'none';
                                               document.getElementById("user").style.display = 'block';
                                               document.getElementById("botStarterMessage").innerHTML = '<p class="botText"><span>' + "Hello " + nameInput.value + '</span></p>';
                                               let time = getTime();
                                               document.getElementById("userInput").scrollIntoView(false);
                                               let botHtml = '<p class="botText"><span>' + "May I help you ?" + '</span></p>';
                                               $("#chatbox").append(botHtml);

                                               document.getElementById("chat-bar-bottom").scrollIntoView(true);
                                               websocket.send(nameInput.value);
                                               nameInput.value = "";
                                           }

                                           function getTime() {
                                               let today = new Date();
                                               hours = today.getHours();
                                               minutes = today.getMinutes();

                                               if (hours < 10) {
                                                   hours = "0" + hours;
                                               }

                                               if (minutes < 10) {
                                                   minutes = "0" + minutes;
                                               }

                                               let time = hours + ":" + minutes;
                                               return time;
                                           }
    </script>

