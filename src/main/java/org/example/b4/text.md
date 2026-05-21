1. Phân tích so sánh
   Bảng so sánh
   Tiêu chí         	             @RestControllerAdvice          	@AfterThrowing
   Phạm vi hoạt động	             Tầng Web / Controller	            Tầng Service / AOP
   Mục đích chính	                 Chuẩn hóa HTTP Response         	Theo dõi & ghi log lỗi
   Can thiệp JSON trả về	         ✔ Rất mạnh	                        ✘ Không phù hợp
   Trả HTTP Status	                 ✔ Có	                            ✘ Không
   Ẩn StackTrace khỏi client	     ✔ Tốt	                            ✘ Không trực tiếp
   Ghi log bí mật	                 Có thể nhưng không tối ưu	        ✔ Tốt nhất
   Tách biệt concern	              ✔	                                   ✔
   Ảnh hưởng business logic        	 Không	                            Không
   Dùng cho audit/debug    	         Không tối ưu	                    ✔ Rất phù hợp


2. Kết luận lựa chọn
   Dùng @RestControllerAdvice

Để:

Gom lỗi toàn cục
Trả JSON chuẩn cho frontend
Trả HTTP Status phù hợp
Ẩn StackTrace khỏi client

Ví dụ:

{
"status": 404,
"message": "Không tìm thấy khóa học"
}
Dùng @AfterThrowing

Để:

Ghi log nội bộ
Audit lỗi hệ thống
Debug bí mật
Theo dõi lỗi service

Ví dụ log:

[ERROR LOG]
Method: getCourseById
Message: Course not found
3. Tại sao cần kết hợp cả hai?

Nếu chỉ dùng:

@RestControllerAdvice

→ frontend đẹp nhưng thiếu logging nội bộ.

@AfterThrowing

→ có log nhưng không kiểm soát được JSON API.

Giải pháp tối ưu
Service throw Exception
↓
@AfterThrowing ghi log bí mật
↓
@RestControllerAdvice trả JSON chuẩn