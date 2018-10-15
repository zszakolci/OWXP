***
[TOC levels=1-5]
***
# Summary
The **backend** uses [flexmark](https://github.com/vsch/flexmark-java) (version 0.34.24)  with the following extensions:
AutolinkExtension, EmojiExtension, FootnoteExtension, GitLabExtension, GfmIssuesExtension, GfmUsersExtension, SuperscriptExtension, StrikethroughExtension, TablesExtension, TaskListExtension, TocExtension ([extensions](https://github.com/vsch/flexmark-java/wiki/Extensions)).

The **fronted** uses [StackEdit](https://github.com/benweet/stackedit.js).


# Features

## StackEdit editor
You can use the embedded StackEdit editor when editing a page by clicking on **Edit with StackEdit**.

![Edit with StackEdit](https://grow.liferay.com/documents/portlet_file_entry/20147/editor.png/005dc1ec-654c-0a09-e741-29bf4dd50f9a?status=0&download=true)

![enter image description here](https://grow.liferay.com/documents/portlet_file_entry/20147/editorInUse.PNG/2aaffced-ae0f-aa9f-cd52-889920b1c596?status=0&download=true)

 
### Bold, italic, strikethrough
**This** *is just a sample* ~~text~~.

### Headers
This is already the example :).

### Unordered list
 - List item A
 - List item B
 - List item C

### Ordered lists

 1. List item A
 2. List item B
 3. List item C

### Check list:

 - [x] Check A
 - [ ] Check B
 - [x] Check C

### Blockquote
> **Lorem Ipsum** is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.

### Code:

	@Override
	public String convert(
			WikiPage page, PortletURL viewPageURL, PortletURL editPageURL,
			String attachmentURLPrefix)
		throws PageContentException {

		Parser parser = _parserThreadLocal.get();
		HtmlRenderer renderer = _rendererThreadLocal.get();

		Node document = parser.parse(page.getContent());

		return renderer.render(document);
	}

### Tables:

|I know,| tables look a bit different|
|--|--|
|we'll need to align| the CSS in the Grow theme|


### Links:
[This is a link to Grow.](http://grow.liferay.com)

### Images
See the already used images. I added them as attachment first, but you can use any URLs as the source.

## Emoji     
 :blush:
Use the [Emoji Cheat Sheet](https://www.webfx.com/tools/emoji-cheat-sheet/).


## Footnotes
You can create footnotes like this [^testFootnote].
Also you can collect your links like this(check the bottom of the source): [Footnotes extension short][footnoteLink1], [Footnotes extension ][footnoteLink1]

## Superscript
You ^can add text as superscript like this.^
Probably a better example if you want to write: 3^rd^ party.

## Table of contents
Add TOC in brackets, see the source on top of this page.
Default is to include heading levels 2 and 3, but you can configure it:
 See [Table of Contents Extension](https://github.com/vsch/flexmark-java/wiki/Table-of-Contents-Extension) for extra options.
 **Note:**
**ToC** doesn't show up in the editor view.

## GitLab Flavored Markdown (GFM)
See [GitLab Flavored Markdown (GFM)](https://gitlab.com/gitlab-org/gitlab-ce/blob/master/doc/user/markdown.md).
## Syntax highlight
You can check the [Syntax Highlighting on GROW](https://grow.liferay.com/share/Syntax+Highlighting+on+GROW) page for further options.

**Java:**
```java
private MutableDataSet _getOptions() {
		MutableDataSet options = new MutableDataSet();

		// uncomment to set optional extensions

		options.set(
			Parser.EXTENSIONS,
			Arrays.asList(
				EmojiExtension.create(), GitLabExtension.create(),
				GfmIssuesExtension.create(), GfmUsersExtension.create(),
				StrikethroughExtension.create(), TablesExtension.create(),
				TaskListExtension.create(), TocExtension.create()));

		options.set(
			EmojiExtension.ROOT_IMAGE_PATH, "/o/grow-theme/images/emojis/");

		// Use 2 dashes to be compatible with StackEdit

		options.set(TablesExtension.MIN_SEPARATOR_DASHES, 2);

		// uncomment to convert soft-breaks to hard breaks

		options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		return options;
	}
```
**HTML:**
```html
<!doctype html>
<html>
	<head>
		<style>
		body{
			font-family: sans-serif;
			overflow: hidden;
			text-align: center;
			width: 150px;
		}
		</style>
	</head>
	<body>
		<img src="icons/icon.svg" width="64">
		<h1>LESAgna</h1>
		<p>Version: <span id="version">x.x.x</span></p>
		<p><a href="https://issues.liferay.com/browse/LRSUPPORT-18558" target="_blank">Bug/New feature</a></p>
		<script src="scripts/popup.js"></script>
	</body>
</html>
```
# Tips and tricks
I really like the interactive table on the [Package Breaking Changes Since DXP Release](https://grow.liferay.com/share/Package+Breaking+Changes+Since+DXP+Release?sourceVersion=7110-dxp-2&targetVersion=7110-dxp-2) page.

# Known issues/limitations

 - As the backend and the frontend uses a different markdown engine, there is no guarantee that the page will look exactly the same at the end as in the editor. If something looks really bad, please report an issue.
 - Bugs/improvements:
   - [Markdown - Editor doesn't work on Safari](https://issues.liferay.com/browse/GROW-711)
	- [Markdown - Tables look ugly](https://issues.liferay.com/browse/GROW-708)
	- [Markdown - Table of contents doesn't jump to the section exactly](https://issues.liferay.com/browse/GROW-704)
	- [Markdown - footnotes are small](https://issues.liferay.com/browse/GROW-705)
	

  


[^testFootnote]:See, this is quite simple. 


[footnoteLink1]: https://github.com/vsch/flexmark-java/wiki/Extensions#footnotes
[footnoteLink2]: https://github.com/vsch/flexmark-java/wiki/Footnotes-Extension
