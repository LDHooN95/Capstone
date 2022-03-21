$(document).ready(function(){
    var maxAppend = 1;
    var num=2;
    $('#delete').click(function() {
        if(maxAppend==1) return;
        $('#T5 > tbody:last>tr:last').remove();

        $('#T5 > tbody:last>tr:last').remove();

        $('#T5 > tbody:last>tr:last').remove();
        num--;
        maxAppend--;
    });
    $("#add").click(function (e) {
        if (maxAppend >= 3) return;
        $('#T5>tbody:last').append('<tr style = "text-align:center; vertical-align: middle;"><td rowspan = "3">'+num+'지망</td>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "Building" class = "form-control input-sm ">\n' +
            '                                                <option>강의건물</option>\n' +
            '                                                <option value = "대양AI센터">대양AI센터</option>\n' +
            '                                                <option value = "율곡관">율곡관</option>\n' +
            '                                                <option value = "광개토관">광개토관</option>\n' +
            '                                                <option value = "충무관">충무관</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "Classroom" class = "form-control input-sm">\n' +
            '                                                <option>강의실</option>\n' +
            '                                                <option value = "B201">B201</option>\n' +
            '                                                <option value = "B202">B202</option>\n' +
            '                                                <option value = "B203">B203</option>\n' +
            '                                                <option value = "B101">B101</option>\n' +
            '                                                <option value = "B102">B102</option>\n' +
            '                                                <option value = "B103">B103</option>\n' +
            '                                                <option value = "B104">B104</option>\n' +
            '                                                <option value = "101A">101A</option>\n' +
            '                                                <option value = "101B">101B</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "days" class = "form-control input-sm">\n' +
            '                                                <option>강의요일</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <input type = "text" name = "Start_time" list = "time1.11" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택" >\n' +
            '                                            <datalist id = "time1.11">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <input type = "text" name = "End_time" list = "time1.12" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택">\n' +
            '                                            <datalist id = "time1.12">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                    </tr>\n' +
            '                                    <!--1row2-->\n' +
            '                                    <tr>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "Building" class = "form-control input-sm">\n' +
            '                                                <option>강의건물</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "Classroom" class = "form-control input-sm">\n' +
            '                                                <option>강의실</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <select  name = "days" class = "form-control input-sm">\n' +
            '                                                <option>강의요일</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <input type = "text" name = "Start_time" list = "time1.21" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택하십시오">\n' +
            '                                            <datalist id = "time1.21">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                        <td>\n' +
            '                                            <input type = "text" name = "End_time" list = "time1.22" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택하십시오">\n' +
            '                                            <datalist id = "time1.22">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                    </tr>\n'+
            '                               <!--1row3-->\n' +
            '                                    <tr>\n' +
            '                                        <td style="border-bottom:3px solid #284350;">\n' +
            '                                            <select  name = "Building" class = "form-control input-sm">\n' +
            '                                                <option>강의건물</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td style="border-bottom:3px solid #284350;">\n' +
            '                                            <select  name = "Classroom" class = "form-control input-sm">\n' +
            '                                                <option>강의실</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td style="border-bottom:3px solid #284350;">\n' +
            '                                            <select  name = "days" class = "form-control input-sm">\n' +
            '                                                <option>강의요일</option>\n' +
            '                                                <option value = "월">월</option>\n' +
            '                                                <option value = "화">화</option>\n' +
            '                                                <option value = "수">수</option>\n' +
            '                                                <option value = "목">목</option>\n' +
            '                                                <option value = "금">금</option>\n' +
            '                                            </select>\n' +
            '                                        </td>\n' +
            '                                        <td style="border-bottom:3px solid #284350;">\n' +
            '                                            <input type = "text" name = "Start_time" list = "time1.21" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택하십시오">\n' +
            '                                            <datalist id = "time1.31">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                        <td style="border-bottom:3px solid #284350;">\n' +
            '                                            <input type = "text" name = "End_time" list = "time1.22" class = "form-control input-sm input-field col s6" style="top: 10px;" placeholder = "입력/선택하십시오">\n' +
            '                                            <datalist id = "time1.32">\n' +
            '                                                <option><오전></오전></option>\n' +
            '                                                <option value = "08:00" >08:00</option>\n' +
            '                                                <option value = "08:30">08:30</option>\n' +
            '                                                <option value = "09:00">09:00</option>\n' +
            '                                                <option value = "09:30">09:30</option>\n' +
            '                                                <option value = "10:00">10:00</option>\n' +
            '                                                <option value = "10:30">10:30</option>\n' +
            '                                                <option value = "11:00">11:00</option>\n' +
            '                                                <option value = "11:30">11:30</option></optgroup>\n' +
            '                                                <option><오후></오후></option>\n' +
            '                                                <option value = "12:00">12:00</option>\n' +
            '                                                <option value = "12:30">12:30</option>\n' +
            '                                                <option value = "13:00">13:00</option>\n' +
            '                                                <option value = "13:30">13:30</option>\n' +
            '                                                <option value = "14:00">14:00</option>\n' +
            '                                                <option value = "14:30">14:30</option>\n' +
            '                                                <option value = "15:00">15:00</option>\n' +
            '                                                <option value = "15:30">15:30</option>\n' +
            '                                                <option value = "16:00">16:00</option>\n' +
            '                                                <option value = "16:30">16:30</option>\n' +
            '                                                <option value = "17:00">17:00</option>\n' +
            '                                                <option value = "17:30">17:30</option>\n' +
            '                                                <option value = "18:00">18:00</option>\n' +
            '                                                <option value = "18:30">18:30</option>\n' +
            '                                                <option value = "19:00">19:00</option>\n' +
            '                                                <option value = "19:30">19:30</option>\n' +
            '                                                <option value = "20:00">20:00</option>\n' +
            '                                                <option value = "20:30">20:30</option>\n' +
            '                                                <option value = "21:00">21:00</option>\n' +
            '                                                <option value = "21:30">21:30</option>\n' +
            '                                                <option value = "22:00">22:00</option>\n' +
            '                                                </optgroup>\n' +
            '                                            </datalist>\n' +
            '                                        </td>\n' +
            '                                    </tr>');
    maxAppend++;
    num++;
    });
    return false;
});
    