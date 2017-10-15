<html>

<head></head>

<body>
    <!-- Include stylesheet -->
    <link href="https://cdn.quilljs.com/1.3.3/quill.snow.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/monokai-sublime.min.css">
    <!-- Create the editor container -->
    <div id="editor">
        <p>Hello World!</p>
        <p>Some initial
            <strong>bold</strong> text</p>
        <p>
            <br>
        </p>
    </div>

    <!-- Include the Quill library -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
    <script src="https://cdn.quilljs.com/1.3.3/quill.js"></script>

    <!-- Initialize Quill editor -->
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
    </script>
</body>

</html>
