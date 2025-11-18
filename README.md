# SSH Configuration for Git CLI

This guide walks you through configuring SSH authentication with Git CLI for secure repository access.

## Prerequisites

- Git installed on your system
- Access to a terminal/command line
- A Git hosting account (GitHub, GitLab, or Bitbucket)

## 1. Check for Existing SSH Keys

First, check if you already have SSH keys:

```bash
ls -al ~/.ssh
```

Look for files like `id_rsa.pub`, `id_ed25519.pub`, or `id_ecdsa.pub`.

## 2. Generate a New SSH Key

If you don't have an SSH key, generate one using Ed25519 (recommended):

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

**For legacy systems** that don't support Ed25519, use RSA:

```bash
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

**During key generation:**
- Press Enter to accept the default file location (`~/.ssh/id_ed25519`)
- Optionally set a passphrase for additional security
- Press Enter again to confirm the passphrase

## 3. Start the SSH Agent

Start the SSH agent in the background:

```bash
eval "$(ssh-agent -s)"
```

You should see output like: `Agent pid 12345`

## 4. Add Your SSH Key to the Agent

Add your SSH private key to the SSH agent:

```bash
ssh-add ~/.ssh/id_ed25519
```

**Note:** If you generated an RSA key, use `~/.ssh/id_rsa` instead.

## 5. Copy Your Public Key

Display your public key:

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy the entire output (it should start with `ssh-ed25519` or `ssh-rsa`).

**Alternative method** (copies directly to clipboard):

- **macOS:** `pbcopy < ~/.ssh/id_ed25519.pub`
- **Linux (with xclip):** `xclip -selection clipboard < ~/.ssh/id_ed25519.pub`
- **Windows (Git Bash):** `clip < ~/.ssh/id_ed25519.pub`

## 6. Add SSH Key to Your Git Provider

### GitHub

1. Go to [GitHub Settings](https://github.com/settings/keys)
2. Click **SSH and GPG keys** → **New SSH key**
3. Add a descriptive title (e.g., "Work Laptop")
4. Paste your public key in the "Key" field
5. Click **Add SSH key**

### GitLab

1. Go to [GitLab Preferences](https://gitlab.com/-/profile/keys)
2. Click **SSH Keys**
3. Paste your public key in the "Key" field
4. Add a title and optional expiration date
5. Click **Add key**

### Bitbucket

1. Go to [Bitbucket Personal Settings](https://bitbucket.org/account/settings/ssh-keys/)
2. Click **SSH keys** → **Add key**
3. Add a label
4. Paste your public key
5. Click **Add key**

## 7. Test Your SSH Connection

Verify that your SSH key is working:

**GitHub:**
```bash
ssh -T git@github.com
```

**GitLab:**
```bash
ssh -T git@gitlab.com
```

**Bitbucket:**
```bash
ssh -T git@bitbucket.org
```

You should see a success message like: `Hi username! You've successfully authenticated...`

## 8. Using SSH with Git

### Clone a Repository Using SSH

```bash
git clone git@github.com:username/repository.git
```

### Switch Existing Repository from HTTPS to SSH

Check your current remote URL:
```bash
git remote -v
```

Change to SSH:
```bash
git remote set-url origin git@github.com:username/repository.git
```

Verify the change:
```bash
git remote -v
```

## Troubleshooting

### Permission Denied (publickey)

If you get a "Permission denied" error:

1. Verify your SSH key is added to the agent: `ssh-add -l`
2. Check that you've added the correct public key to your Git provider
3. Ensure you're using the correct SSH URL format
4. Try adding your key again: `ssh-add ~/.ssh/id_ed25519`

### SSH Agent Not Running

If the SSH agent isn't running, start it:

```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
```

### Wrong Key Being Used

If you have multiple SSH keys, specify which one to use:

```bash
ssh-add -D  # Remove all keys
ssh-add ~/.ssh/id_ed25519  # Add specific key
```

## Additional Configuration (Optional)

### SSH Config File

Create or edit `~/.ssh/config` to manage multiple keys or customize settings:

```
Host github.com
    HostName github.com
    User git
    IdentityFile ~/.ssh/id_ed25519
    
Host gitlab.com
    HostName gitlab.com
    User git
    IdentityFile ~/.ssh/id_ed25519_gitlab
```

## Security Best Practices

- Use a strong passphrase for your SSH key
- Never share your private key (`id_ed25519` or `id_rsa`)
- Only share your public key (`.pub` files)
- Regularly rotate your SSH keys
- Use different keys for different services if needed
- Remove old or unused SSH keys from your Git provider

## Resources

- [GitHub SSH Documentation](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)
- [GitLab SSH Documentation](https://docs.gitlab.com/ee/user/ssh.html)
- [Bitbucket SSH Documentation](https://support.atlassian.com/bitbucket-cloud/docs/set-up-an-ssh-key/)

---

**License:** MIT  
**Last Updated:** November 2025
