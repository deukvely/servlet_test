/**
 * 
 */
class Todo{
	todoList(callback){
		$.ajax({
			url: '../AjaxTodoSelect.do',
			success: function(data){
				callback(data);
			}
		})
	}
			
	todoInsert(param, callback, errorcall){
	$.ajax({
			url: '../AjaxTodoInsert.do',
			data: param,
			success: function (data){
				callback(data);
			},
			error: function(err){
				errorcall(err);
			}
		})
	}
	
	todoDelete(todoNumber, callback){
		$.ajax({
			url: '../AjaxTodoDelete.do?todoNumber='+ todoNumber,
			success: function(){
				var number = todoNumber;
				console.log(todoNumber)
				callback(number);			
			}
		})
	}
}