# Workflow

The git workflow used by this project is a slightly modified GitLab workflow.
If you are familiar with the GitLab workflow, you should have no problems using this workflow.

## 0. Install

To install Git, please use the oficial Git ppa:

```
$ sudo add-apt-repository ppa:git-core/ppa
$ sudo apt-get update
$ sudo apt-get install git
```

## 1. Fork
You first should fork this project into your repositories. Do this by clicking the **Fork** button in the upper right corner.


## 2. Initialize Git Repository
You must initialize a Git repository in the repository's folder of the project in your machine. Do this by performing:

```
$ git init
```


## 3. Add Remotes
Then, you need to set two remotes in you machine: `upstream` and `origin`  
The `upstream` remote must point to the organization repos. You can configure using SSH or HTTPS protocol:  
    
```
$ git remote add upstream git@github.com:FHBrasil/KPFamily.git
$ git remote add upstream https://github.com/FHBrasil/KPFamily.git
```

The `origin` remote must point to your forked repos. You can configure using SSH or HTTPS protocol:

```
$ git remote add origin git@github.com:<username>/KPFamily.git
$ git remote add origin https://github.com/<username>/KPFamily.git
```


## 4. Configure
Your machine must have the following configuration for Git. You can copy and paste this codes into you local machine:

```
$ cd <project_home>
$ git config --global user.name "Name LastName" 
$ git config --global user.email "name.lastname@fh.com.br" 

$ git config --global core.filemode false
$ git config --global core.editor vim <or vi, nano, gedit, etc...>

$ git config --global alias.lg "log --graph --abbrev-commit --decorate --date=iso --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%cd)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --since=7.days" 
$ git config --global alias.st "status -sb" 
$ git config --global merge.ours.driver true

$ git config --global pull.ff only
$ git config --global merge.ff false

$ git config core.excludesfile gitignore
```

## 5. Work
To start you work, first you need to update your upstream/master branch, and then create a new feature branch from it.  
The feature branch should have a correct naming patter: `feature dash issue-task-number dash short-text`:
    
```
$ git fetch upstream master
$ git checkout upstream/master
$ git checkout -b feature-<issue-number>-<short-text>
```

###### Examples of good feature branch naming:
```
feature-2285-dispatchViaForwarder
feature-2382-metaTagBrandSubPage
feature-2397-newcmscomponent-categorypage
feature-2538-altTagInProductPanels
feature-2617-sliderForFilters
```

After open a new `feature` branch, you need to run _Gradle_, selection the `localhost` recipe, in order to have the right environment configuration:

```
$ cd <project_home>
$ ./installer/install.sh -r localhost -P<platform_home>
```

> Keep in mind that `platform_home`, is the complete path to your Hybris platform folder.  
> For example: `/HYBRIS/hybris/bin/platform`.

To commit your changes, use:

```
$ git add <files>
$ git commit
```

## 6. Push
After you commited your changes into you local branch, you need to push it to `origin` repos, and then, make a Pull Request to the `upstream` repos

```
$ git push origin feature-*
```

Make `Pull Request` via GitHub web interface (navigating to the repository)  
Keep in mind that you can Pull Request to the `release-candidate` branch (QA branch), and/or `master` branch (production).

## 7. Commit Defaults

Remember to commit early and often.  
Nerver make a commit that does not compile, or have any errors.  
The commit message should follow this pattern:  

```
First line should have a summary of the changes in that commmit. Use less than 50 characters.
Blank line
Redmine Issue link
Another blank line
A text explaining what, how and why those changes are in this commit. Use no more than 72 characters PER LINE
Another blank line
a dash (-) and the Issue integration with Redmine.
```
 
Follow this basic rules for a good commit message:
* Do not use *pronouns*. Write the message like the changes happened by itself.
* Be clear and explicit
* Use the imperative mood
* If the commit fixes a problem, explain what the problem is and what is the solution to that problem
* If the commit creates a new funcionality, explain it was made, and how it should work
* It’s perfectly OK to spend more time crafting your commit message than writing the code for your commit.
* It’s perfectly OK for your commit message to be longer than your commit.

To integrate your commit to Redmine, you should write some special word (called fixing keywords) in you commit messages:
Fixing keywords that changes the Issue status to "in progress" and changes the % done to the number:

```
%10: <issue-number> -> sets the Issue to 10% done and "Doing" status on Redmine
%20: <issue-number>
%30: <issue-number>
%40: <issue-number>
%50: <issue-number>
%60: <issue-number>
%70: <issue-number>
%80: <issue-number>
%90: <issue-number>
%100: <issue-number> -> sets the Issue to 100% and "Resolved" status on Redmine
```

**pay attention to the comma after the '%number'**


Here's an example of a good commit message, that will change the issue #11 to 40% done and put it as "Doing", and log time to 1 hour and 15 minutes of work.

```
Fix uninitialised temp_foreign_map

http://redmine.fliegersoftware.de/<project>/issues/11

When calculate_cpu_foreign_map() recalculates the cpu_foreign_map
cpumask it uses the local variable temp_foreign_map without initialising
it to zero. Since the calculation only ever sets bits in this cpumask
any existing bits at that memory location will remain set and find their
way into cpu_foreign_map too. This could potentially lead to cache
operations suboptimally doing smp calls to multiple VPEs in the same
core, even though the VPEs share primary caches.

Therefore initialise temp_foreign_map using cpumask_clear() before use.

- %40: #11 @1h30m" 
```

