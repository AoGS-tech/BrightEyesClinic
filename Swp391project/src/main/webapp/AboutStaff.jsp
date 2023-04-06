<%-- 
    Document   : AboutStaff
    Created on : Mar 7, 2023, 10:34:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="layout/head.jsp"/>
        
        
        <style>
            .detail ul li{
                font-size: 15px;
              
            }
            .detail p strong{
                font-size: 20px;
                
                color: black;
            }
        </style>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="" style="font-size: 50px;color: #E55F67;margin-left: 8%; margin-top: 7%">Đội ngũ bác sĩ hàng đầu</div>

        <div class="description" style="margin-left: 8%; margin-top: 3%">“Chúng tôi đặt mình vào vị trí của người bệnh để lắng nghe, thấu hiểu và sẻ chia.”</div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-9">
        <img src="assets/images/doi-ngu-bac-si.png" style="width: 90%;height: 100%;margin-left: 5%;margin-right: 5%"class="custom-block-image img-fluid" alt="">
        </div>
            </div>
        <div class="description" style="margin-left: 25%; margin-top: 2%; margin-right: 15%; text-align: center">Bệnh viện mắt quốc tế Nhật Bản hội tụ các bác sỹ nhãn khoa giàu kinh nghiệm đến từ Việt Nam và Nhật Bản. Với mục tiêu nâng cao chất lượng khám chữa bệnh, mang lại hiệu quả điều trị tốt ưu cho người bệnh, đội ngũ Bác sỹ thường xuyên được cập nhật các công nghệ, phương pháp điều trị mới trong nhãn khoa thông qua các khóa đào tạo, các hội thảo trong nước và quốc tế.</div>
   
        <div class="row">
            <div class="col-md-3"></div>
        <div class="col-md-8"  style="display: flex; justify-content: space-between; margin-top: 3%;">
            <div>
                <div class="text-center"><span class="number" style="font-size: 60px; color: #66ccff">04</span></div>
                 <div class="text-center"><span class="text-r" >Bác sĩ nhãn khoa</span></div>
            </div>

        <div class="">
            <div class="text-center"><span class="number" style="font-size: 60px; color: #66ccff">250.000+</span></div>
            <div class="text-center"><span class="text-r">Lượt thăm khám</span></div>
        </div>

        <div class="">
            <div class="text-center"><span class="number" style="font-size: 60px; color: #66ccff;">30.000+</span></div>
            <div class="text-center"><span class="text-r">Ca phẫu thuật thành công</span></div>
        </div>
            <div class="col-md-1"></div>
        </div>
            
        </div>
        <br>
        <br>
        
        
        <div class="row" style="">
           
        <div class="">
            <div style=" font-size: 50px;color: #E55F67;margin-left: 8%; margin-top: 7% ; ">Giáo sư, Bác sỹ</div>
            <div class="" style="font-size: 50px;color: #E55F67;margin-left: 8%;">Bui Anh Vu</div>
            <div style="margin-left: 8%; margin-top: 2%; font-size: 20px">PHÒNG TRƯỞNG DANH DỰ</div>
                        </div>
                  
          <div class="row" >
               <div class="col-md-1"></div>
               <div style="margin-left: 4%; margin-top: 2%;" class="col-md-4 detail">
           <p><strong>CHUYÊN KHOA</strong></p>
           <ul >
            <li>Phẫu thuật cắt dịch kính</li>
            <li>Phẫu thuật đục thủy tinh thể</li>
            <li>Chẩn đoán và điều trị các bệnh lý về đáy mắt</li>
        </ul>

        <p><strong>GIẢI THƯỞNG</strong></p>

    <ul>
	<li>Huy chương hữu nghị do Chủ tịch nước Cộng hòa xã hội chủ nghĩa Việt Nam trao tặng.</li>
	<li>Kỷ niệm chương "Vì sức khỏe nhân dân" do Bộ Y Tế Việt Nam trao tặng.</li>
	<li>Giải thưởng "Người mang Nhật Bản đến với Thế giới" do Nội các Nhật Bản và Bộ Trưởng Bộ Ngoại Vụ Nhật Bản trao tặng.</li>
    </ul>

        <p><strong>KINH NGHIỆM</strong></p>

    <ul>
	<li>Giáo sư, Bác sỹ Hattori Tadashi là một trong những chuyên gia hàng đầu tại Nhật Bản trong lĩnh vực điều trị các bệnh về đáy mắt, thủy tinh thể. Đồng thời, ông là bác sỹ phẫu thuật hàng đầu thế giới với phương pháp Cắt dịch kính và phẫu thuật Phaco.</li>
	<li>Giáo sư thỉnh giảng tại trường Đại học Osaka.</li>
	<li>Chuyên gia mời giảng tại Bệnh viện mắt trung ương từ năm 2002 đến nay, đào tạo hơn 20 bác sỹ chuyên khoa mắt với tay nghề cao tại các bệnh viện ở Việt Nam.</li>
	<li>Giám đốc điều hành của Tổ chức phòng chống mù lòa Châu Á (APBA).</li>
    </ul>
        </div>
               <div class="col-md-2"> 
                <img src="assets/images/Vu-bui.png">
            </div>    
               
         </div>  
            </div>  
    <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
    
</html>
