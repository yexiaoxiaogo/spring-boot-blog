<html>

<head>
	<title>写文章</title>
	<#include "./common/head.ftl">
	
    <link href="https://cdn.quilljs.com/1.3.3/quill.snow.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/monokai-sublime.min.css">
</head>

<body>
    <#include "./common/header.ftl">
    <div class='w980 d-flex flex-column'>
    		<button id='publish' class="btn btn-success mb-3 align-self-end">发布文章</button>
    		<div id="editor"></div>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
    <script src="https://cdn.quilljs.com/1.3.3/quill.js"></script>

    <script>
        // var fonts = ['sofia', 'slabo', 'roboto', 'inconsolata', 'ubuntu'];
        hljs.configure({   // optionally configure hljs
            languages: ['javascript', 'ruby', 'python']
        });
        
        var quill = new Quill('#editor', {
            modules: {
                // 'formula': true,
                'syntax': true,
                'toolbar': [
                    [{ 'size': [] }],
                    ['bold', 'italic', 'underline', 'strike'],
                    [{ 'color': [] }, { 'background': [] }],
                    [{ 'script': 'super' }, { 'script': 'sub' }],
                    [{ 'header': '1' }, { 'header': '2' }, 'blockquote', 'code-block'],
                    [{ 'list': 'ordered' }, { 'list': 'bullet' }, { 'indent': '-1' }, { 'indent': '+1' }],
                    ['direction', { 'align': [] }],
                    ['link', 'image', 'video', 'formula'],
                    ['clean']
                ],
            },
            theme: 'snow'
        });
        
        $('#publish').on('click', function() {
        		var editor = document.querySelector('#editor');
        		
        		fetch('/test/api/post', {
        			method: 'post',
        			body: JSON.stringify({
            			blog: editor.firstChild.innerHTML,
            			title: editor.firstChild.firstChild && editor.firstChild.firstChild.innerText || '暂无标题',
            		}),
            		headers: {
            			'Content-Type': 'application/json'
            		}
        		}).then(function(r) {
        			return r.json();
        		}).then(function(d) {
        			
        			// location.href = '/abc'
        		});
        });
    </script>
</body>

</html>
