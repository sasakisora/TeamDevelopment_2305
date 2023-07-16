function confirmDelete() {
	if(confirm("本当にこのユーザーを削除しますか？")) {
		// 削除の処理を行う
	} else {
		// 削除をキャンセルする
	}
	function goBack() {
		window.history.back();
	}
}
