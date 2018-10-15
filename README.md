## Introduction to groovy scripts

From time to time we need to repair a customer's database, because it's corrupted. If we know what we want to do, a **groovy** script could be more than enough.

Groovy scripts are also useful for testing certain behaviors that would otherwise require us to build a portlet.

You can check the page about [creating groovy scripts here](https://grow.liferay.com/excellence/How+to+create+groovy+scripts)

**This article's purpose is to collect the scripts** which could useful for others, by either reusing them, or just to learn from the solution.

## Liferay Support Scripts repository

Liferay Support Scripts repository is located in liferay-support-ee github repository:

[**github.com/liferay/liferay-support-ee/tree/master/scripts**](https://github.com/liferay/liferay-support-ee/tree/master/scripts)

There is a copy of repository attached to this page, see file [**liferay-support-script-repository.zip**](https://grow.liferay.com/documents/portlet_file_entry/20147/liferay-support-script-repository.zip/166f2f13-8693-aa31-779e-1f1026c7998e?status=0&download=true)

It contains both customer and internal use scripts:


Folder       | Description 
---          | ---
`for-customers` | Scripts that were written to some customer in the past, you can review and give them to a customer (but be careful)
`internal` | Internal scripts, don't give them to any customer. For example, scripts to generate data.

### Find scripts using github search
You can also use github search functionality to search the groovy scripts, for example if you type `path:/scripts create journalArticle` [you will search "create journalArticle" in **/scripts** folder](https://github.com/liferay/liferay-support-ee/search?q=path%3A%2Fscripts+create+journalArticle&unscoped_q=path%3A%2Fscripts+create+journalArticle)

For more information about github search see: https://help.github.com/articles/searching-code/#search-by-the-location-of-a-file-within-the-repository

### How to Contribute
If you want to contribute any script, please send a pull request to any liferay-support-ee reviewer.

More information see grow page: [Review checklist for support tools, scripts to the liferay-support-ee git repository](https://grow.liferay.com/people/Review+checklist+for+support+tools%3CCOMMA%3E+scripts+to+the+liferay-support-ee+git+repository)

Scripts must follow this rules:

 - **Filename:** It should be: descriptiveName_version.language, ex: `fixSomethingScript_62x.groovy`
 - **Description:** Script should have a small comment with the description about its purpose
 - **Privacy:** No customer name or other specific customer information should exist inside the script
 - **Location:** Script should be uploaded in the correct category. You should also update README.md file.
 - *(optional)* **Read-only/dry-run mode:** a configurable boolean read-only flag is advisable, in order to be able to test the script before applying the changes
